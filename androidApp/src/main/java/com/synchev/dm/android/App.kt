package com.synchev.dm.android

import android.app.Application
import android.content.Context
import com.di.initKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        initKoin(
            module {
                single { this@App }.bind<Context>()
            }
        )
    }

}