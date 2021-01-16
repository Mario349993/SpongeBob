package com.shop.ui.home.home.brand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shop.BR
import com.shop.R
import com.shop.databinding.ActivityBrandBinding
import com.shop.viewmodel.BrandViewModel


class BrandActivity : AppCompatActivity() {
    var mBinding: ActivityBrandBinding? = null
    var vm: BrandViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_brand)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_brand)
        initVM()
        
    }

    fun initVM(){
        vm = ViewModelProvider(this).get(BrandViewModel::class.java)
        vm !!.homebrandData()
        vm !!.stauts.observe(this, Observer {
            if (it == 0){
                mBinding!!.setVariable(BR.brand,vm)
            }
        })
    }
}