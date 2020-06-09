package com.slava.takeawaytest

import android.app.Application
import com.slava.takeawaytest.di.AppModule
import com.slava.takeawaytest.persistence.RestaurantsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RestaurantsApplication : Application() {

    companion object {
        lateinit var instance: RestaurantsApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        RestaurantsDatabase.getInstance(this)
        startKoin {
            androidContext(this@RestaurantsApplication)
            modules(AppModule)
        }
    }
}