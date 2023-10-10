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
        println("xertz: here")
        initKoin(
            module {
                single { this@App }.bind<Context>()
            }
        )
    }

}