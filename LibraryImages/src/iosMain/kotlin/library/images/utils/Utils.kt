package library.images.utils

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.usePinned
import platform.CoreCrypto.CC_MD5
import platform.CoreCrypto.CC_MD5_DIGEST_LENGTH
import platform.Foundation.NSData
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create
import platform.Foundation.dataUsingEncoding
import platform.darwin.ByteVar
import platform.posix.memcpy

typealias ImageBytes = NSData

fun String.lastPathComponentWithoutFileExt(): String =
    this.substringAfterLast(delimiter = "/").removeFileExt()

fun String.removeFileExt(): String =
    this.substringBeforeLast(delimiter = ".")

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
fun ByteArray.toImageBytes(): ImageBytes = memScoped {
    NSData.create(
        bytes = allocArrayOf(this@toImageBytes),
        length = this@toImageBytes.size.toULong()
    )
}


@OptIn(ExperimentalForeignApi::class)
fun ImageBytes.toByteArray(): ByteArray = ByteArray(this@toByteArray.length.toInt()).apply {
    usePinned {
        memcpy(it.addressOf(0), this@toByteArray.bytes, this@toByteArray.length)
    }
}

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
fun String.toDiskCacheKey(): String {
    memScoped {
        val digest = allocArray<ByteVar>(CC_MD5_DIGEST_LENGTH)
        val messageData =
            NSString.create(string = this@toDiskCacheKey).dataUsingEncoding(NSUTF8StringEncoding)
                ?: return this@toDiskCacheKey
        CC_MD5(messageData.bytes, messageData.length.toUInt(), digest)
        return digest.readBytes(CC_MD5_DIGEST_LENGTH)
            .joinToString("") { it.toString(16).padStart(2, '0') }
    }
}

