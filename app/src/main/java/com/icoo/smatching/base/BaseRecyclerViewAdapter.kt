package com.icoo.smatching.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<ITEM : Any, T : ViewDataBinding>
    :RecyclerView.Adapter<BaseRecyclerViewAdapter<ITEM, T>.ViewHolder>() {

    lateinit var viewDataBinding: T

    abstract val bindingVariableId: Int
    abstract val layoutResID: Int
    abstract val listener: OnItemClickListener?

    private val viewModel: BaseViewModel? = null
    val items = mutableListOf<ITEM>()

    fun replaceAll(items: List<ITEM>?) {
        items?.let {
            this.items.run {
                clear()
                addAll(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutResID, parent, false)
        return ViewHolder(viewDataBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(private val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(item: Any?) {
            try {
                bindingVariableId.let {
                    dataBinding.root.setOnClickListener {
                        listener?.onItemClicked(item) }
                    dataBinding.setVariable(it, item)
                    dataBinding.executePendingBindings()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: Any?)
    }
}