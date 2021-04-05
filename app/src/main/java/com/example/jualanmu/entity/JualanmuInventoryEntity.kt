package com.example.jualanmu.entity

import android.os.Parcelable
import com.example.jualanmu.*
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class JualanmuInventoryEntity(
    @SerializedName(KEY_UID) val userId: String = "",
    @SerializedName(KEY_SHOP_ID)val shopId: String = "",
    @SerializedName(KEY_CATEGORY) val category: String = "",
    @SerializedName(KEY_CODE) val code: String = "",
    @SerializedName(KEY_COST) val cost: Int = 0,
    @SerializedName(KEY_CURRENT_STOCK) val currentStock: Int = 0,
    @SerializedName(KEY_ID) val id: Int = 0,
    @SerializedName(KEY_IMAGE) val image: String = "",
    @SerializedName(KEY_MARGIN) val margin: Int = 0,
    @SerializedName(KEY_MINIMUM_STOCK) val minimumStock: Int = 0,
    @SerializedName(KEY_NAME) val name: String = "",
    @SerializedName(KEY_PRICE) val price: Int = 0,
    @SerializedName(KEY_TIME_STAMP) val timeStamp: String = ""
) : Parcelable