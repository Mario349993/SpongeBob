package com.shop.model.api


import com.shop.ui.home.home.brand.BrandData
import com.shop.net.BaseResp
import com.shop.ui.home.bean.HomeBean
import com.shop.ui.home.bean.type.TypeBean
import com.shop.ui.home.bean.type.TypeInfoBean
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ServiceApi {


    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken(): BaseResp<String>


    //首页
    @GET("index")
    // BaseResp抽取的一个bean类的外层结构 homeData当前接口返回的具体
    suspend fun getHome():BaseResp<HomeBean>

    //品牌制造
    @GET("brand/list")
    suspend fun getBrand():BaseResp<BrandData>

    //专题
    @GET("topic/list?page=1&size=10")
    suspend fun getTopic():BaseResp<TypeBean>

    //https://cdplay.cn/api/catalog/index 分类竖着导航
    @GET("catalog/index")
    suspend fun getType() : TypeBean

    // https://cdplay.cn/api/  用来请求当前分类的列表数据
    @GET("catalog/current")
    suspend fun getTypeInfo(@Query("id")id : Int) : TypeInfoBean


}