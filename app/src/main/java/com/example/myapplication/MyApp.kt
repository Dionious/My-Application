package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.modules.myModule
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(myModule)
        }
    }
    }
