package com.icoo.smatching.data.remote.api

import com.icoo.smatching.util.Settings
import io.reactivex.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface NetworkService {

    companion object {
        fun create(): NetworkService {
            return Retrofit.Builder()
                .baseUrl(Settings.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
    }
}