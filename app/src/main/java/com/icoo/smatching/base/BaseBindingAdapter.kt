package com.icoo.smatching.base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

//Base
@Suppress("UNCHECKED_CAST")
@BindingAdapter("replaceAll")
fun RecyclerView.replaceAll(list: List<Any>?) {
    (this.adapter as? BaseRecyclerViewAdapter<Any, *>)?.run {
        replaceAll(list)
        notifyDataSetChanged()
    }
}