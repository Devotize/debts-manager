package library.images.remote

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin


internal actual val engineFactory: HttpClientEngine = Darwin.create()
