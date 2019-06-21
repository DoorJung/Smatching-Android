package com.icoo.smatching.ui.main.myPage

import android.os.Bundle
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseFragment
import com.icoo.smatching.databinding.FragMyPageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPageFragment : BaseFragment<FragMyPageBinding, MyPageViewModel>() {

    override val layoutResID: Int
        get() = R.layout.frag_my_page
    override val viewModel: MyPageViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.vm = viewModel
    }

    companion object {
        private val TAG = "MyPageFragment"
    }
}