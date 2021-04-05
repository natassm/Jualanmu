package com.example.jualanmu.screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jualanmu.DATA_CREATE
import com.example.jualanmu.DATA_UPDATE
import com.example.jualanmu.R
import com.example.jualanmu.entity.JualanmuInventoryEntity
import com.example.jualanmu.support.JualanmuRouter
import com.example.jualanmu.support.adapter.recyclerview.JualanmuInventoryListRecyclerView
import com.example.jualanmu.support.adapter.recyclerview.viewholder.JualanmuInventoryListener
import com.example.jualanmu.viewmodel.JualanmuInventoryCreateUpdateViewModel
import com.example.jualanmu.viewmodel.JualanmuInventoryListViewModel
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class JualanmuInventoryFragment: Fragment(), View.OnClickListener {

    private lateinit var inventoryAdapter: JualanmuInventoryListRecyclerView
    private val inventoryListViewModel: JualanmuInventoryListViewModel by lazy { ViewModelProvider(this).get(
        JualanmuInventoryListViewModel::class.java)}

    private val inventoryListListener = object : JualanmuInventoryListener {
        override fun onItemClicked(entity: JualanmuInventoryEntity) {
            this@JualanmuInventoryFragment.context?.let {
                startActivity(JualanmuRouter.onGoToCreateDetail(it, entity, DATA_UPDATE))
            }
        }

        override fun onDeleteClicked(entity: JualanmuInventoryEntity) {
            inventoryListViewModel.deleteItem(entity.id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        inventoryListViewModel.getList()
        initiateViewModels()

        toolbarRightTextView.setOnClickListener(this)
        inventoryNoDataFoundAddDataTextView.setOnClickListener(this)
        toolbarBackImageView.visibility = View.GONE
        toolbarRightTextView.text = getString(R.string.add)
        toolbarTitleTextView.text = getString(R.string.inventory)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.inventoryNoDataFoundAddDataTextView -> {
                this@JualanmuInventoryFragment.context?.let {
                    startActivity(JualanmuRouter.onGoToCreateDetail(it, null, DATA_CREATE))
                }
            }
            R.id.toolbarRightTextView -> {
                this@JualanmuInventoryFragment.context?.let {
                    startActivity(JualanmuRouter.onGoToCreateDetail(it, null, DATA_CREATE))
                }
            }
        }
    }

    private fun initiateViewModels() {
        inventoryListViewModel.inventoryListLiveData.observe(viewLifecycleOwner, Observer {

            setUpUI()
            inventoryAdapter = JualanmuInventoryListRecyclerView(it, inventoryListListener)

            inventoryRecyclerView.apply {
                layoutManager = object : LinearLayoutManager(context) {
                    override fun canScrollVertically(): Boolean { return false }

                    override fun canScrollHorizontally(): Boolean { return false } }
                itemAnimator = DefaultItemAnimator()
                adapter = inventoryAdapter
            }

            inventoryAdapter.notifyDataSetChanged()
        })

        inventoryListViewModel.deleteInventoryLiveData.observe(viewLifecycleOwner, Observer {
            inventoryAdapter.notifyDataSetChanged()

            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.detach(this)?.attach(this)?.commit()
        })
    }

    private fun setUpUI() {
        inventoryNoDataFoundLayout.visibility = if (inventoryListViewModel.inventoryList.size == 0) View.VISIBLE else View.GONE
        inventoryRecyclerView.visibility = if (inventoryListViewModel.inventoryList.size == 0) View.GONE else View.VISIBLE
        toolbarRightTextView.visibility = if (inventoryListViewModel.inventoryList.size == 0) View.GONE else View.VISIBLE
    }
}