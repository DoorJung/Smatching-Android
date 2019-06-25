package com.icoo.smatching.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseActivity
import com.icoo.smatching.base.BasePagerAdapter
import com.icoo.smatching.databinding.ActMainBinding
import com.icoo.smatching.ui.main.home.HomeFragment
import com.icoo.smatching.ui.main.myPage.MyPageFragment
import com.icoo.smatching.ui.main.smatching.SmatchingFragment
import com.icoo.smatching.ui.main.talk.TalkFragment
import org.jetbrains.anko.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActMainBinding, MainViewModel>() {

    override val layoutResID: Int
        get() = R.layout.act_main
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Toolbar
        setSupportActionBar(viewDataBinding.actMainTb)
        supportActionBar!!.title = ""
        viewDataBinding.actMainTb.layoutParams.height += getStatusBarHeight()
        viewDataBinding.actMainTb.setPadding(0, getStatusBarHeight(), 0, 0);

        //ViewPager
        viewDataBinding.actMainVp.run {
            adapter = BasePagerAdapter(supportFragmentManager).apply {
                addFragment(HomeFragment())
                addFragment(SmatchingFragment())
                addFragment(TalkFragment())
                addFragment(MyPageFragment())
            }
            //Refresh menu
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
                override fun onPageSelected(position: Int) {
                    invalidateOptionsMenu()
                }

                override fun onPageScrollStateChanged(state: Int) {}
            })

            offscreenPageLimit = 3
        }
        //TabLayout
        viewDataBinding.actMainTl.run {
            //Customizing tab icon
            val navigationLayout: View =
                LayoutInflater.from(this@MainActivity).inflate(R.layout.act_main_navigation, null, false)//inflate뷰를 붙여줌
            setupWithViewPager(viewDataBinding.actMainVp)
            getTabAt(0)!!.customView =
                navigationLayout.findViewById(R.id.act_main_navigation_rl_home) as RelativeLayout
            getTabAt(1)!!.customView =
                navigationLayout.findViewById(R.id.act_main_navigation_rl_smatching) as RelativeLayout
            getTabAt(2)!!.customView =
                navigationLayout.findViewById(R.id.act_main_navigation_rl_talk) as RelativeLayout
            getTabAt(3)!!.customView =
                navigationLayout.findViewById(R.id.act_main_navigation_rl_my_page) as RelativeLayout
            //TabSelectedListener
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewModel.setTitle(tab.position)
                    when (tab.position) {
                        0 -> {
                            viewDataBinding.actMainTvTitle.run { text = "홈"; setTextColor(resources.getColor(R.color.title)) }
                            viewDataBinding.actMainTb.setBackgroundColor(resources.getColor(R.color.bg))
                        }
                        1 -> {
                            viewDataBinding.actMainTvTitle.run { text = "맞춤 지원"; setTextColor(resources.getColor(R.color.title)) }
                            viewDataBinding.actMainTb.setBackgroundColor(resources.getColor(R.color.bg))
                        }
                        2 -> {
                            viewDataBinding.actMainTvTitle.run { text = "창업 토크"; setTextColor(resources.getColor(R.color.title)) }
                            viewDataBinding.actMainTb.setBackgroundColor(resources.getColor(R.color.bg))
                        }
                        3 -> {
                            viewDataBinding.actMainTvTitle.run { text = "마이페이지"; setTextColor(resources.getColor(R.color.white)) }
                            viewDataBinding.actMainTb.setBackgroundColor(resources.getColor(R.color.myPageBg))
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        when (viewDataBinding.actMainVp.currentItem) {
            0, 1, 2 -> {
                menu.findItem(R.id.menu_main_notice).icon = resources.getDrawable(R.drawable.icn_notice)
                menu.findItem(R.id.menu_main_setting).setVisible(false)
            }
            3 -> {
                menu.findItem(R.id.menu_main_notice).icon = resources.getDrawable(R.drawable.icn_notice_white)
                menu.findItem(R.id.menu_main_search).setVisible(false)
                menu.findItem(R.id.menu_main_setting).setVisible(true)
            }
        }
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_main_search -> {
                Log.d(TAG, "검색")
            }
            R.id.menu_main_setting -> {
                Log.d(TAG, "설정")
            }
            R.id.menu_main_notice -> {
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
        private val TAG = "MainActivity"
    }
}