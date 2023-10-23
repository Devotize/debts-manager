package library.images.cache.internal

import io.github.aakira.napier.Napier
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import library.images.utils.LOG_TAG
import library.images.utils.lastPathComponentWithoutFileExt
import library.images.utils.toByteArray
import library.images.utils.toDiskCacheKey
import library.images.utils.toImageBytes
import platform.Foundation.NSBundle
import platform.Foundation.NSData
import platform.Foundation.NSDate
import platform.Foundation.NSDirectoryEnumerationSkipsHiddenFiles
import platform.Foundation.NSError
import platform.Foundation.NSFileManager
import platform.Foundation.NSFileModificationDate
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSURL
import platform.Foundation.NSURLPathKey
import platform.Foundation.allObjects
import platform.Foundation.create
import platform.Foundation.writeToFile
import platform.darwin.DISPATCH_TIME_FOREVER
import platform.darwin.dispatch_semaphore_create
import platform.darwin.dispatch_semaphore_signal
import platform.darwin.dispatch_semaphore_wait

class DiskCache {

    private val semaphore = dispatch_semaphore_create(1)
    private val entries = mutableMapOf<String, NSDate>()

    private val directoryPath: String

    @Suppress("unused")
    private val count get() = entries.count()

    private val fileManager: NSFileManager

    init {
        val sb = StringBuilder()
        sb.append(NSTemporaryDirectory())
        val bIdentifier = NSBundle.mainBundle().bundleIdentifier
        bIdentifier?.let {
            sb.append("$it/")
        }
        sb.append("thumbnails/")
        directoryPath = sb.toString()
        fileManager = NSFileManager.defaultManager()
        initializeFields()
    }

    @OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
    private fun initializeFields() {
        if (!fileManager.fileExistsAtPath(directoryPath)) {
            memScoped {
                val errorPtr: ObjCObjectVar<NSError?> = alloc()
                fileManager.createDirectoryAtPath(directoryPath, true, null, errorPtr.ptr)
                errorPtr.value?.let {
                    Napier.e(tag = LOG_TAG) { "Caught error while trying to create temporary directory for storing images: ${it.localizedDescription}" }
                }
            }
        }

        // Get file list
        val enumerator = fileManager.enumeratorAtURL(
            NSURL(fileURLWithPath = directoryPath),
            includingPropertiesForKeys = listOf(NSURLPathKey),
            options = NSDirectoryEnumerationSkipsHiddenFiles,
            errorHandler = { _, nsError ->
                Napier.e(tag = LOG_TAG) { "Caught error while trying get enumerator: ${nsError?.localizedDescription}" }
                false
            }
        )
        (enumerator?.allObjects)?.forEach { fileUrl ->
            (fileUrl as? NSURL)?.let {
                it.path?.let { path ->
                    val attributes = fileManager.attributesOfItemAtPath(path, error = null)
                    val modificationDate = (attributes?.get(NSFileModificationDate) as? NSDate)
                    if (modificationDate != null) {
                        fileManager.removeItemAtPath(path, error = null).also { isDeleted ->
                            if (!isDeleted) {
                                entries[path.lastPathComponentWithoutFileExt()] = modificationDate
                            }
                        }
                    }
                }
            }
        }
    }

    fun put(key: String, value: ByteArray) {
        val cacheKey = key.toDiskCacheKey()
        try {
            val filePath = "${directoryPath}$cacheKey.txt"
            dispatch_semaphore_wait(semaphore, DISPATCH_TIME_FOREVER)
            if (!fileManager.fileExistsAtPath(filePath)) {
                NSFileManager.defaultManager.createFileAtPath(
                    filePath,
                    contents = null,
                    attributes = null
                ).also {
                    Napier.i(tag = LOG_TAG) { "Is file created at path: $filePath -> $it" }
                }
            }
            val data = value.toImageBytes()
            data.writeToFile(filePath, atomically = true)
            entries[cacheKey] = NSDate()
            Napier.i(tag = LOG_TAG) { "Successfully put image with key: $cacheKey to disk cache" }
        } catch (e: Exception) {
            Napier.e(tag = LOG_TAG) { "Caught error while trying to put image with key: $cacheKey to disk cache, reason: ${e.message}" }
        } finally {
            dispatch_semaphore_signal(semaphore)
        }
    }

    @OptIn(BetaInteropApi::class)
    fun get(key: String): ByteArray? {
        val cacheKey = key.toDiskCacheKey()
        if (!entries.containsKey(cacheKey)) {
            Napier.i(tag = LOG_TAG) { "Image with key: $cacheKey not found in disk cache" }
            return null
        }
        return try {
            val filePath = "$directoryPath$cacheKey.txt"
            dispatch_semaphore_wait(semaphore, DISPATCH_TIME_FOREVER)
            val data = NSData.create(contentsOfFile = filePath)
            data?.toByteArray().also {
                if (it != null) {
                    Napier.i(tag = LOG_TAG) { "Successfully found image with key: $cacheKey from disk cache" }
                } else {
                    Napier.i(tag = LOG_TAG) { "Failed to process image with key: $cacheKey from disk cache" }
                }
            }
        } catch (e: Exception) {
            Napier.e(tag = LOG_TAG) { "Caught error while trying to extract image with key: $cacheKey from disk cache, reason: ${e.message}" }
            null
        } finally {
            dispatch_semaphore_signal(semaphore)
        }
    }

}