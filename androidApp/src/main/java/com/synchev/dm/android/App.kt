package com.synchev.dm.android

import android.app.Application
import android.content.Context
import com.di.initKoin
import library.images.initializer.Pergamon
import org.koin.dsl.bind
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
        Pergamon.init(this)
    }

    private fun initDI() {
        initKoin(
            module {
                single { this@App }.bind<Context>()
            }
        )
    }

}