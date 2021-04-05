package com.example.jualanmu.support.adapter.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.jualanmu.R
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.support.JualanmuHelper
import kotlinx.android.synthetic.main.view_holder_inventory.view.*

class JualanmuInventoryListViewHolder(view: View, private val listener: JualanmuInventoryListener): RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var inventoryEntity: JualanmuInventoryEntity

    init {
        JualanmuHelper.buildOnClickListener(this, itemView.viewHolderInventoryBase, itemView.viewHolderDeleteImageView)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.viewHolderInventoryBase -> listener.onItemClicked(inventoryEntity)
            R.id.viewHolderDeleteImageView -> listener.onDeleteClicked(inventoryEntity)
        }
    }

    fun setUpModelToUI(entity: JualanmuInventoryEntity) {
        this.inventoryEntity = entity

        itemView.viewHolderItemNameTextView.text = entity.name
        itemView.viewHolderItemPriceTextView.text = "Rp " + entity.price.toString()
        itemView.viewHolderItemTextView.text = entity.userId
        itemView.viewHolderStockTextView.text = "Stok: " + entity.currentStock.toString()
    }
}

interface JualanmuInventoryListener {
    fun onItemClicked(entity: JualanmuInventoryEntity)
    fun onDeleteClicked(entity: JualanmuInventoryEntity)
}