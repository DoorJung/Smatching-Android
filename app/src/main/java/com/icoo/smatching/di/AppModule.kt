package com.icoo.smatching.di

import com.icoo.smatching.data.local.pref.PreferenceManager
import com.icoo.smatching.data.remote.api.NetworkService
import com.icoo.smatching.ui.main.MainViewModel
import com.icoo.smatching.ui.main.home.HomeViewModel
import com.icoo.smatching.ui.main.myPage.MyPageViewModel
import com.icoo.smatching.ui.main.smatching.SmatchingViewModel
import com.icoo.smatching.ui.main.talk.TalkViewModel
import com.icoo.smatching.util.AndroidSchedulerProvider
import com.icoo.smatching.util.SchedulerProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rxModule = module {
    //provide schedule provider
    factory<SchedulerProvider> { AndroidSchedulerProvider() }
}

val networkModule = module {
    single { NetworkService.create() }
}

val localModule = module {
    //SharedPreference
    single { PreferenceManager(get()) }
    //Room
}

val factoryModule = module {

}

val viewModule = module {
    //main
    viewModel { MainViewModel() }
    //home
    viewModel { HomeViewModel() }
    //smatching
    viewModel { SmatchingViewModel() }
    //talk
    viewModel { TalkViewModel() }
    //myPage
    viewModel { MyPageViewModel() }
}

val appModule = listOf(rxModule, networkModule, localModule, factoryModule, viewModule)