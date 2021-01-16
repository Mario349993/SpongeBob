package com.shop.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shop.R
import com.shop.databinding.ActivityBindingHomeBinding
import com.shop.ui.home.BindHomeAdapter

class BindingHomeActivity : AppCompatActivity() {
    var mBinding:ActivityBindingHomeBinding? = null
    var adapter:BindHomeAdapter? = null
    var viewModel:BindHomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding_home)
        viewModel = ViewModelProvider(this).get(BindHomeViewModel::class.java)
        initView()
        initVM()
        viewModel!!.homeData()
    }
    private fun initView(){
        val layoutManager = LinearLayoutManager(this)
        mBinding!!.recyBrend.layoutManager = layoutManager
        adapter = BindHomeAdapter(this)
        mBinding!!.recyBrend.adapter = adapter
    }
    private fun initVM(){
        viewModel!!.brand.observe(this, Observer {
            adapter!!.refreshData(it)
        })
    }
}