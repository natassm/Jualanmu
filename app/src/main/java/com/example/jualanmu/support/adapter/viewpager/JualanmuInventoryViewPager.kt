package com.example.jualanmu.support.adapter.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.KEY_DATA
import com.example.jualanmu.screen.fragment.JualanmuInventoryFragment

class JualanmuInventoryViewPager (fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> JualanmuInventoryFragment()
            else -> JualanmuInventoryFragment()
        }
    }

    override fun getCount(): Int = 1
}