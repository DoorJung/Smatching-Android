package com.icoo.smatching.ui.main.smatching

import android.os.Bundle
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseFragment
import com.icoo.smatching.databinding.FragSmatchingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SmatchingFragment : BaseFragment<FragSmatchingBinding, SmatchingViewModel>() {

    override val layoutResID: Int
        get() = R.layout.frag_smatching
    override val viewModel: SmatchingViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.vm = viewModel
    }

    companion object {
        private val TAG = "SmatchingFragment"
    }
}