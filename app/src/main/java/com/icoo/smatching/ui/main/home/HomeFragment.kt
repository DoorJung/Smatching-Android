package com.icoo.smatching.ui.main.home

import android.os.Bundle
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseFragment
import com.icoo.smatching.databinding.FragHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragHomeBinding, HomeViewModel>() {

    override val layoutResID: Int
        get() = R.layout.frag_home
    override val viewModel: HomeViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.vm = viewModel
    }

    companion object {
        private val TAG = "HomeFragment"
    }
}