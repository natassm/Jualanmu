package com.example.jualanmu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.google.firebase.database.*

class JualanmuInventoryListViewModel: ViewModel() {

    private val inventoryListMutableLiveData: MutableLiveData<MutableList<JualanmuInventoryEntity>> = MutableLiveData()
    val inventoryListLiveData: LiveData<MutableList<JualanmuInventoryEntity>> = inventoryListMutableLiveData

    private val deleteInventoryMutableLiveData: MutableLiveData<MutableList<JualanmuInventoryEntity>> = MutableLiveData()
    val deleteInventoryLiveData: LiveData<MutableList<JualanmuInventoryEntity>> = deleteInventoryMutableLiveData

    var inventoryList: MutableList<JualanmuInventoryEntity> = mutableListOf()
    lateinit var ref: DatabaseReference

    fun getList() {
        ref = FirebaseDatabase.getInstance().getReference("inventory")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {}

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    inventoryList.clear()

                    for (h in snapshot.children) {
                        val inventory = h.getValue(JualanmuInventoryEntity::class.java)
                        inventoryList.add(inventory!!)
                    }

                    inventoryListMutableLiveData.value = inventoryList
                }
            }

        })
    }

    fun deleteItem(id: String) {
        ref = FirebaseDatabase.getInstance().getReference("inventory")
        ref.child(id).removeValue()
        deleteInventoryMutableLiveData.value = inventoryList
    }
}