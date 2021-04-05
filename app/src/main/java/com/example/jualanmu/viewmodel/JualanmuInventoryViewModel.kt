package com.example.jualanmu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jualanmu.entity.JualanmuInventoryEntity

class JualanmuInventoryViewModel: ViewModel() {

    private val inventoryMutableLiveData: MutableLiveData<JualanmuInventoryEntity> = MutableLiveData()
    val inventoryLiveData: LiveData<JualanmuInventoryEntity> = inventoryMutableLiveData

    var inventoryList: MutableList<JualanmuInventoryEntity> = mutableListOf()
}