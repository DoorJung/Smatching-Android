package com.icoo.smatching.base

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.icoo.smatching.di.testAppModule
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
abstract class BaseTest : KoinTest {

    @Before
    open fun before() {
        stopKoin()
        startKoin{
            androidContext(InstrumentationRegistry.getInstrumentation().context)
            modules(testAppModule)
        }
    }

    @After
    open fun after() {
        stopKoin()
    }
}