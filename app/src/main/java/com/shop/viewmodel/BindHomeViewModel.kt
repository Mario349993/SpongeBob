package com.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.shop.model.Brand
import com.shop.model.HomeData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class BindHomeViewModel:ViewModel() {

    var brand:MutableLiveData<List<Brand>> = MutableLiveData(listOf())


    fun homeData(){
        GlobalScope.launch {
            loadData()
        }
    }

    suspend fun loadData(){
        var homeData = get("https://cdplay.cn/api/index")
        if (homeData != null){
            brand.postValue(homeData.data.brandList)
        }else{
        }
    }

    /**
     *
     */
    suspend fun get(str:String) = withContext(Dispatchers.IO){
        var result = URL(str).readText(charset("utf-8"))
        return@withContext Gson().fromJson<HomeData>(result,homeData()::class.java)
    }
}