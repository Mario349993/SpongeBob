package com.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLogin:ViewModel() {

    var name:String? = ""

    var age:MutableLiveData<Int> = MutableLiveData()



}