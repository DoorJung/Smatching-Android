package com.icoo.smatching

import android.app.Application
import com.icoo.smatching.data.local.db.SmatchingDatabase
import com.icoo.smatching.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SmatchingDatabase.getInstance(this@MyApplication)
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}