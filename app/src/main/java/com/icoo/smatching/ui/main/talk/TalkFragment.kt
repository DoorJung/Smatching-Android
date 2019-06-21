package com.icoo.smatching.ui.main.talk

import android.os.Bundle
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseFragment
import com.icoo.smatching.databinding.FragTalkBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TalkFragment : BaseFragment<FragTalkBinding, TalkViewModel>() {

    override val layoutResID: Int
        get() = R.layout.frag_talk
    override val viewModel: TalkViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.vm = viewModel
    }

    companion object {
        private val TAG = "TalkFragment"
    }
}