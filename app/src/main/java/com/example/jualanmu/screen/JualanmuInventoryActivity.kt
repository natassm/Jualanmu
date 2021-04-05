package com.example.jualanmu.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jualanmu.R
import com.example.jualanmu.viewmodel.JualanmuInventoryViewModel
import kotlinx.android.synthetic.main.activity_inventory.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class JualanmuInventoryActivity: AppCompatActivity(), View.OnClickListener{

    private val inventoryViewModel: JualanmuInventoryViewModel by lazy { ViewModelProvider(this).get(
        JualanmuInventoryViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        initiateViewModels()

        toolbarTitleTextView.text = getString(R.string.add_item)
        toolbarRightTextView.text = getString(R.string.add)

        toolbarRightTextView.setOnClickListener(this)
    }

    private fun initiateViewModels() {
        inventoryViewModel.inventoryLiveData.observe(this, Observer {
            Toast.makeText(this, "Sukses Tambah Data", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.toolbarRightTextView -> {
                if (inventoryItemNameEditText.text.isNotEmpty()) {
                    inventoryViewModel.createInventory(inventoryItemNameEditText.text.toString(),
                        inventoryCategoryEditText.text.toString(), inventoryCodeEditText.text.toString(),
                        inventoryCostEditText.text.toString().toInt(), inventoryMarginEditText.text.toString().toInt(),
                        inventoryPriceEditText.text.toString().toInt(), inventoryStockEditText.text.toString().toInt(),
                        inventoryMinStockEditText.text.toString().toInt())

                    finish()
                } else {
                    Toast.makeText(this, "Mohon isi seluruh data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}