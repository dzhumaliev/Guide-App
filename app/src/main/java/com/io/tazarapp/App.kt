package com.io.tazarapp

import android.app.Application
import android.content.Context
import com.io.tazarapp.modules.networkModule
import com.io.tazarapp.modules.repositoryModule
import com.io.tazarapp.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    repositoryModule,
                    networkModule,
                    viewModelModule
                )
            )
        }
    }
}