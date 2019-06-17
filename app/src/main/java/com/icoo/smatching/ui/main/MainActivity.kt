package com.icoo.smatching.ui.main

import android.os.Bundle
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseActivity
import com.icoo.smatching.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResID: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
