package com.example.jualanmu.screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jualanmu.R
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.support.adapter.viewpager.JualanmuInventoryViewPager
import kotlinx.android.synthetic.main.fragment_inventory.*

class JualanmuInventoryFragment: Fragment(), View.OnClickListener {

    private lateinit var inventoryAdapter: JualanmuInventoryViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inventoryNoDataFoundAddDataTextView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.inventoryNoDataFoundAddDataTextView -> { }
        }
    }

    private fun setUpAdapter() {
//        inventoryAdapter = JualanmuInventoryViewPager(childFragmentManager, JualanmuInventoryEntity)
    }
}