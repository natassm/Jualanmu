package com.example.jualanmu.support

import android.content.Context
import android.content.Intent
import com.example.jualanmu.KEY_DATA
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.screen.JualanmuInventoryActivity

object JualanmuRouter {

    fun onGoToCreateDetail(context: Context, inventoryEntity: JualanmuInventoryEntity? = null): Intent {
        val intent = Intent(context, JualanmuInventoryActivity::class.java)
        intent.putExtra(KEY_DATA, inventoryEntity)
        return intent
    }

}