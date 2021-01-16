package com.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.shop.ui.home.bean.type.Category
import com.shop.ui.home.bean.type.TypeInfoBean
import kotlinx.coroutines.launch

class TypeViewModel : BaseViewModel(Injection.repository){
    var gettype : MutableLiveData<List<Category>> = MutableLiveData()
    var gettype_info : MutableLiveData<List<TypeInfoBean.CurrentCategory>> = MutableLiveData()

    //获取分类
    fun getType(){
        //TODO 调用数据仓库需要协程产生一个联系
        viewModelScope.launch {
            var result = repository.getType()
            gettype.postValue(result.categoryList)
            refreshToken
        }
    }

    //获取分类的数据
    fun getTypeInfo(id : Int){
        //TODO 调用数据仓库需要协程产生一个联系
        viewModelScope.launch {
            var result = repository.getTypeData(id)
            gettype_info.postValue(listOf(result.currentCategory))
            refreshToken
        }
    }
}