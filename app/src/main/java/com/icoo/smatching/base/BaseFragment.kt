package com.icoo.smatching.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding, R : BaseViewModel> : Fragment() {
    lateinit var viewDataBinding: T

    abstract val layoutResID: Int
    abstract val viewModel: R

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResID, container, false)
        viewDataBinding.lifecycleOwner = this@BaseFragment
        return viewDataBinding.root
    }
}