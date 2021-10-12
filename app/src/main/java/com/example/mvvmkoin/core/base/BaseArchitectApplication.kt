package com.example.mvvmkoin.core.base

import android.app.Application
import com.example.mvvmkoin.core.network.networtModule
import com.example.mvvmkoin.dashboard.module.dashboardModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class BaseArchitectApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger(Level.INFO)
            androidContext(this@BaseArchitectApplication)
            koin.loadModules(
                listOf(
                    networtModule,
                    dashboardModule
                )
            )
        }
    }
}