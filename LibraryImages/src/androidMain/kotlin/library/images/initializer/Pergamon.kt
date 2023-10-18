package library.images.initializer

import android.app.Application
import android.content.Context

private var _pergamon: Pergamon? = null
internal val pergamon by lazy { _pergamon ?: error("Pergamon instance has not been initialized") }

class Pergamon private constructor(context: Context) {

    val appContext: Context = context

    companion object {
        fun init(context: Application) {
            _pergamon = Pergamon(context)
        }
    }

}

