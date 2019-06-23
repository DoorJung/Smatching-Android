package com.icoo.smatching.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.icoo.smatching.base.BaseViewModel

class MainViewModel() : BaseViewModel() {

    private val _isTitleVisible = MutableLiveData<Boolean>().apply { postValue(false) }
    val isTitleVisible: LiveData<Boolean> get() = _isTitleVisible
    private val _title = MutableLiveData<String>()
    val title: LiveData<String> get() = _title

    fun setTitle(position: Int) {

    }

    companion object {
        private val TAG = "MainViewModel"
    }
}