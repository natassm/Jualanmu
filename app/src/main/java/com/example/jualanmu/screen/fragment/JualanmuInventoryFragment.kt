package com.example.jualanmu.screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jualanmu.R
import com.example.jualanmu.support.JualanmuRouter
import com.example.jualanmu.support.adapter.viewpager.JualanmuInventoryAdapter
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class JualanmuInventoryFragment: Fragment(), View.OnClickListener {

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
        toolbarBackImageView.visibility = View.GONE
        toolbarRightTextView.visibility = View.GONE
        toolbarTitleTextView.text = getString(R.string.inventory)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.inventoryNoDataFoundAddDataTextView -> {
                this@JualanmuInventoryFragment.context?.let {
                    startActivity(JualanmuRouter.onGoToCreateDetail(it))
                }
            }
        }
    }
}