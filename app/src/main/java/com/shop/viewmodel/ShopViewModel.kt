package com.shop.viewmodel

import androidx.fragment.app.Fragment
import com.shop.ui.home.home.HomeFragment
import com.shop.ui.home.me.MeFragment
import com.shop.ui.home.shoppingcart.ShoppingCartFragment
import com.shop.ui.home.special.SpecialFragment
import com.shop.ui.home.type.TypeFragment

import com.shop.base.BaseViewModel
import com.shop.net.Injection

class ShopViewModel :BaseViewModel(Injection.repository){
    var fragments:MutableList<Fragment> = mutableListOf()

    //添加进入集合
    init {
        fragments.add(HomeFragment.instance)
        fragments.add(SpecialFragment.instance)
        fragments.add(TypeFragment.instance)
        fragments.add(ShoppingCartFragment.instance)
        fragments.add(MeFragment.instance)
    }
}