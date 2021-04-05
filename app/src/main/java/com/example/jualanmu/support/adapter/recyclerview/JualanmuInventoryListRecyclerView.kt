package com.example.jualanmu.support.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.jualanmu.R
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.support.adapter.recyclerview.viewholder.JualanmuInventoryListViewHolder
import com.example.jualanmu.support.adapter.recyclerview.viewholder.JualanmuInventoryListener

class JualanmuInventoryListRecyclerView(private val list: MutableList<JualanmuInventoryEntity>, private val listener: JualanmuInventoryListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = JualanmuInventoryListViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.view_holder_inventory, parent, false), listener)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is JualanmuInventoryListViewHolder) {
            holder.setUpModelToUI(list[position])
        }
    }
}