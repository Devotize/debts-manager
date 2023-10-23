@file:JvmName("PainterJvm")

package library.images.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import library.images.cache.PlatformDiskCache

@Composable
actual fun InitCacheWithContext() {
    if (PlatformDiskCache.isInitialized) return
    PlatformDiskCache.getInstance().initializeWithContext(LocalContext.current)
}