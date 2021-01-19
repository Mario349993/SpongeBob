package com.shop.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shop.ui.home.bean.type.Category
import com.shop.ui.home.type.TypeInfoFragment

class TypeAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

    private var arrayList = ArrayList<TypeInfoFragment>()
    private var category = ArrayList<Category>()

    fun addList(arrayList: ArrayList<TypeInfoFragment>, category: ArrayList<Category>){
        this.arrayList = arrayList
        this.category = category
        notifyDataSetChanged()
    }
    override fun getItem(position: Int): Fragment {
        return arrayList[position]
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return category[position].name
    }
}