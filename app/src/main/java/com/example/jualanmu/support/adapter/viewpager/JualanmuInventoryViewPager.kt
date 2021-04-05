package com.example.jualanmu.support.adapter.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.KEY_DATA

class JualanmuInventoryViewPager (fragmentManager: FragmentManager, private val list: List<JualanmuInventoryEntity>): FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putParcelable(KEY_DATA, list[position])

        val fragment = Fragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int = list.size
}