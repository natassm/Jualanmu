package com.example.jualanmu.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.jualanmu.R
import com.example.jualanmu.support.adapter.viewpager.JualanmuInventoryAdapter
import kotlinx.android.synthetic.main.activity_main.*

class JualanmuMainActivity: AppCompatActivity() {

    private lateinit var adapter: JualanmuInventoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpAdapter()
    }

    private val pageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
        ) {}

        override fun onPageSelected(position: Int) {}
    }

    private fun setUpAdapter() {
        adapter = JualanmuInventoryAdapter(supportFragmentManager)
        mainViewPager.addOnPageChangeListener(pageChangeListener)
        mainViewPager.adapter = adapter
    }
}