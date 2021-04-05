package com.example.jualanmu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.google.firebase.database.*

class JualanmuInventoryViewModel: ViewModel() {

    private val inventoryMutableLiveData: MutableLiveData<JualanmuInventoryEntity> = MutableLiveData()
    val inventoryLiveData: LiveData<JualanmuInventoryEntity> = inventoryMutableLiveData

    var inventoryList: MutableList<JualanmuInventoryEntity> = mutableListOf()
    lateinit var ref: DatabaseReference

    fun createInventory(itemName: String, itemCategory: String, itemCode: String, itemCost: Int,
                        itemMargin: Int, itemPrice: Int, stockQuantity: Int, minStockQuantity: Int) {

        ref = FirebaseDatabase.getInstance().getReference("inventory")

        val userId = ref.push().key.toString()
        val addInventory = JualanmuInventoryEntity(itemName, itemCategory, itemCode, itemCost, itemMargin,
        itemPrice, stockQuantity, minStockQuantity)

        ref.child(userId).setValue(addInventory).addOnCompleteListener {
            inventoryMutableLiveData.value = JualanmuInventoryEntity()
        }
    }
}