package com.example.jualanmu.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jualanmu.DATA_CREATE
import com.example.jualanmu.KEY_DATA
import com.example.jualanmu.KEY_TYPE
import com.example.jualanmu.R
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.viewmodel.JualanmuInventoryCreateUpdateViewModel
import kotlinx.android.synthetic.main.activity_inventory.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class JualanmuInventoryActivity: AppCompatActivity(), View.OnClickListener{

    private var type: String = ""
    private val inventoryViewModel: JualanmuInventoryCreateUpdateViewModel by lazy { ViewModelProvider(this).get(
        JualanmuInventoryCreateUpdateViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        initiateViewModels()
        getDataIntent()

        toolbarTitleTextView.text = getString(R.string.add_item)
        toolbarRightTextView.text = getString(R.string.add)

        toolbarRightTextView.setOnClickListener(this)
        toolbarBackImageView.setOnClickListener(this)
    }

    private fun initiateViewModels() {
        inventoryViewModel.inventoryCreateLiveData.observe(this, Observer {
            Toast.makeText(this, "Sukses Tambah Data", Toast.LENGTH_SHORT).show()
        })

        inventoryViewModel.inventoryUpdateLiveData.observe(this, Observer {
            Toast.makeText(this, "Sukses Mengubah Data", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.toolbarRightTextView -> {
                if (inventoryItemNameEditText.text.isNotEmpty()) {
                    if (type == DATA_CREATE) {
                        inventoryViewModel.createInventory(inventoryItemNameEditText.text.toString(),
                            inventoryCategoryEditText.text.toString(), inventoryCodeEditText.text.toString(),
                            inventoryCostEditText.text.toString().toInt(), inventoryMarginEditText.text.toString().toInt(),
                            inventoryPriceEditText.text.toString().toInt(), inventoryStockEditText.text.toString().toInt(),
                            inventoryMinStockEditText.text.toString().toInt())
                    } else {
                        inventoryViewModel.updateInventory(inventoryItemNameEditText.text.toString(),
                            inventoryCategoryEditText.text.toString(), inventoryCodeEditText.text.toString(),
                            inventoryCostEditText.text.toString().toInt(), inventoryMarginEditText.text.toString().toInt(),
                            inventoryPriceEditText.text.toString().toInt(), inventoryStockEditText.text.toString().toInt(),
                            inventoryMinStockEditText.text.toString().toInt(), inventoryId.text.toString())
                    }
                    finish()
                } else {
                    Toast.makeText(this, "Mohon isi seluruh data", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.toolbarBackImageView -> finish()
        }
    }

    private fun getDataIntent() {
        intent.getParcelableExtra<JualanmuInventoryEntity>(KEY_DATA)?.let {
            inventoryItemNameEditText.setText(it.name)
            inventoryCategoryEditText.setText(it.category)
            inventoryCodeEditText.setText(it.code)
            inventoryCostEditText.setText(it.cost.toString())
            inventoryMarginEditText.setText(it.margin.toString())
            inventoryPriceEditText.setText(it.price.toString())
            inventoryStockEditText.setText(it.currentStock.toString())
            inventoryMinStockEditText.setText(it.minimumStock.toString())
            inventoryId.text = it.id
        }

        intent.getStringExtra(KEY_TYPE)?.let {
            type = it
        }
    }
}