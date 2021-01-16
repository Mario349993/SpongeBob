package com.shop.ui.home.type

import android.os.Bundle
import androidx.lifecycle.Observer
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.databinding.FragmentTypeBinding
import com.shop.ui.home.adapter.TypeAdapter
import com.shop.ui.home.bean.type.Category
import com.shop.viewmodel.TypeViewModel
import kotlinx.android.synthetic.main.fragment_type.*
import kotlin.collections.ArrayList


class TypeFragment : BaseFragment<TypeViewModel, FragmentTypeBinding>
    (R.layout.fragment_type,TypeViewModel::class.java)  {

    //采用伴生对象 companion object==static
    companion object{
        val instance by lazy { TypeFragment() }
    }

    override fun initView() {
        //禁止滑动
        mVp_type.setScanScroll(false)
    }

    override fun initVM() {
        val fragments = ArrayList<TypeInfoFragment>()
        if (!isAdded)return
        mViewModel.gettype.observe(this, Observer { categroy ->
            var title = ArrayList<String>()
            for (i in categroy.indices){
                var id = categroy.get(i).id
                var typeInfoFragment = TypeInfoFragment()
                var bundle = Bundle()
                bundle.putInt("id",id)
                typeInfoFragment.setArguments(bundle)
                fragments.add(typeInfoFragment)

                title[i] = categroy[i].name
            }
            var typeAdapter = TypeAdapter(childFragmentManager)
            mVp_type.adapter = typeAdapter
            typeAdapter.addList(fragments,title)
            mTab_type.setupWithViewPager(mVp_type)
        })
    }

    override fun initData() {
        mViewModel.getType()
    }

    override fun initVariable() {

    }


}