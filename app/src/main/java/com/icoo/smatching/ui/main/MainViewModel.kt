package com.icoo.smatching.ui.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.icoo.smatching.base.BaseViewModel
import com.icoo.smatching.ui.main.search.SearchActivity
import kotlin.reflect.KClass

class MainViewModel() : BaseViewModel() {

    private val _activityToStart = MutableLiveData<Pair<KClass<*>, Bundle?>>()
    val activityToStart: LiveData<Pair<KClass<*>, Bundle?>> get() = _activityToStart

    fun navigate(idx: Int) {
        when (idx) {
            0 -> _activityToStart.postValue(Pair(SearchActivity::class, null))
        }
    }

    companion object {
        private val TAG = "MainViewModel"
    }
}