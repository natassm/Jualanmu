package com.example.jualanmu.support

import android.view.View

object JualanmuHelper {
    fun buildOnClickListener(listener: View.OnClickListener, vararg views: View) {
        for (view in views) {
            view.setOnClickListener(listener)
        }
    }
}