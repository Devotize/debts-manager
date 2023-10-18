@file:JvmName("HttpClientJvm") //https://youtrack.jetbrains.com/issue/KT-21186

package library.images.remote

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

internal actual val engineFactory: HttpClientEngine = OkHttp.create()
