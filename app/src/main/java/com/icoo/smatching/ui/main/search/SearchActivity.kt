package com.icoo.smatching.ui.main.search

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseActivity
import com.icoo.smatching.databinding.ActSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BaseActivity<ActSearchBinding, SearchViewModel>() {

    override val layoutResID: Int
        get() = R.layout.act_search
    override val viewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Toolbar
        setSupportActionBar(viewDataBinding.actSearchTb)
        supportActionBar!!.run {
            title = ""
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.btn_back)
        }
        viewDataBinding.actSearchTb.run {
            layoutParams.height += getStatusBarHeight()
            setPadding(0, getStatusBarHeight(), 0, 0)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.menu_search_notice -> {
                Log.d(TAG, "알림")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0)
            result = resources.getDimensionPixelSize(resourceId)
        return result
    }

    companion object {
        private val TAG = "SearchActivity"
    }
}