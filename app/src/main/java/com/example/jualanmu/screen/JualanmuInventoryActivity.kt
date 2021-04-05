package com.example.jualanmu.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jualanmu.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class JualanmuInventoryActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        toolbarTitleTextView.text = getString(R.string.add_item)
        toolbarRightTextView.text = getString(R.string.add)

    }
}