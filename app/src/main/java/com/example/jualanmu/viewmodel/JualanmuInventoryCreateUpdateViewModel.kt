package com.example.jualanmu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.google.firebase.database.*

class JualanmuInventoryCreateUpdateViewModel: ViewModel() {

    private val inventoryCreateMutableLiveData: MutableLiveData<JualanmuInventoryEntity> = MutableLiveData()
    val inventoryCreateLiveData: LiveData<JualanmuInventoryEntity> = inventoryCreateMutableLiveData

    private val inventoryUpdateMutableLiveData: MutableLiveData<JualanmuInventoryEntity> = MutableLiveData()
    val inventoryUpdateLiveData: LiveData<JualanmuInventoryEntity> = inventoryUpdateMutableLiveData

    lateinit var ref: DatabaseReference

    fun createInventory(itemName: String, itemCategory: String, itemCode: String, itemCost: Int,
                        itemMargin: Int, itemPrice: Int, stockQuantity: Int, minStockQuantity: Int) {

        ref = FirebaseDatabase.getInstance().getReference("inventory")

        val itemId = ref.push().key.toString()
        val addInventory = JualanmuInventoryEntity(itemName, itemCategory, itemCode, itemCost, itemMargin,
        itemPrice, stockQuantity, minStockQuantity, itemId)

        ref.child(itemId).setValue(addInventory).addOnCompleteListener {
            inventoryCreateMutableLiveData.value = JualanmuInventoryEntity()
        }
    }

    fun updateInventory(itemName: String, itemCategory: String, itemCode: String, itemCost: Int,
                        itemMargin: Int, itemPrice: Int, stockQuantity: Int, minStockQuantity: Int, id: String) {

        ref = FirebaseDatabase.getInstance().getReference("inventory")

        val updateInventory = JualanmuInventoryEntity(itemName, itemCategory, itemCode, itemCost, itemMargin,
            itemPrice, stockQuantity, minStockQuantity, id)

        ref.child(id).setValue(updateInventory).addOnCompleteListener {
            inventoryUpdateMutableLiveData.value = JualanmuInventoryEntity()
        }
    }
}