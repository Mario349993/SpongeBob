package com.shop.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.shop.ui.home.bean.type.Category
import com.shop.ui.home.bean.type.TypeInfoBean
import com.shop.ui.home.bean.type.TypeSubCategory
import kotlinx.coroutines.launch

class TypeViewModel : BaseViewModel(Injection.repository){
    var gettype : MutableLiveData<List<Category>> = MutableLiveData()

    //获取 Tab分类
    fun getType(){
        //TODO 调用数据仓库需要协程产生一个联系
        viewModelScope.launch {
            var result = repository.getType()
            gettype.postValue(result.data.categoryList)
            refreshToken
        }
    }


    var gettype_info : MutableLiveData<List<TypeSubCategory>> = MutableLiveData()

    //获取分类 列表的数据
    fun getTypeInfo(id : Int){
        //TODO 调用数据仓库需要协程产生一个联系
        viewModelScope.launch {
            var result = repository.getTypeInfo(id)
            Log.e("TAG", "getTypeInfo: "+result.data.name )
            if(result.errno == 0){
                gettype_info.postValue(listOf(result.data))
            }else{
                Log.e("TAG", "getTypeInfo: "+result.errmsg )
            }
        }
    }
}