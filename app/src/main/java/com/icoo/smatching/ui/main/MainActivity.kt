package com.icoo.smatching.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.icoo.smatching.R
import com.icoo.smatching.base.BaseActivity
import com.icoo.smatching.base.BasePagerAdapter
import com.icoo.smatching.databinding.ActMainBinding
import com.icoo.smatching.ui.main.home.HomeFragment
import com.icoo.smatching.ui.main.myPage.MyPageFragment
import com.icoo.smatching.ui.main.smatching.SmatchingFragment
import com.icoo.smatching.ui.main.talk.TalkFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActMainBinding, MainViewModel>() {

    override val layoutResID: Int
        get() = R.layout.act_main
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ViewPager
        viewDataBinding.actMainVp.run {
            adapter = BasePagerAdapter(supportFragmentManager).apply {
                addFragment(HomeFragment())
                addFragment(SmatchingFragment())
                addFragment(TalkFragment())
                addFragment(MyPageFragment())
            }
            offscreenPageLimit = 3
        }
        //TabLayout
        viewDataBinding.actMainTl.run {
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
        }
    }

    companion object {
        private val TAG = "MainActivity"
    }
}