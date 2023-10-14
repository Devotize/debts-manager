package library.images.utils

import io.github.aakira.napier.Napier

fun logXertz(message: Any?) {
    Napier.d(tag = "XERTZ") { message.toString() }
}