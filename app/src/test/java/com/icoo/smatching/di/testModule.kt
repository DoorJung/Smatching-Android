package com.icoo.smatching.di

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.icoo.smatching.util.SchedulerProvider
import com.icoo.smatching.util.TestSchedulerProvider
import org.koin.dsl.module

val testRxModule = module {
    //provide schedule provider
    factory<SchedulerProvider> { TestSchedulerProvider() }
}

val contextModule = module {
    //provide schedule provider
    single { ApplicationProvider.getApplicationContext<Context>() }
}

val testAppModule = listOf(testRxModule, networkModule, localModule, factoryModule, viewModule)