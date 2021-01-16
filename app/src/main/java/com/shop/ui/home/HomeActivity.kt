package com.shop.ui.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shop.R
import com.shop.model.Banner
import com.shop.ui.home.adapter.*
import com.shop.viewmodel.HomeViewModel
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.android.synthetic.main.channel_item.view.*
import kotlinx.android.synthetic.main.fragment_home_item.view.*

class HomeActivity : AppCompatActivity() {
    lateinit var homeVM:HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

       // initView()
        //协程

       // homeVM.loadHomeData()
    }

   /* private fun initView(){
        //初始化ViewModel
        homeVM = ViewModelProvider(this).get(HomeViewModel::class.java)
        //监听网络状态的变化
        homeVM.loadStatus.observe(this, Observer { status ->
            if (status == -1){
                Log.i("TAG","数据加载失败")
            }
        })

        //TODO 首页banner 数据
        homeVM.banner.observe(this, Observer { banner ->
            banner_home!!.setImages(banner).setImageLoader(object:ImageLoader(){
                override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                    var pic = path as Banner
                    Glide.with(context!!).load(pic.image_url).into(imageView!!)
                }
            }).start()
        })

        //TODO  动态栏
        homeVM.channel.observe(this, Observer { channel ->
            //清除所有布局
            layout_tab.removeAllViews()
            //权重
            val layoutParams = LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f)
            //循环
            for (i in channel.indices){
                val inflater = LayoutInflater.from(this).inflate(R.layout.channel_item,null)
                inflater.channel_title.text = channel.get(i).name
                Glide.with(this).load(channel.get(i).icon_url).into(inflater.channel_img)
                inflater.channel_title.gravity = Gravity.CENTER //文字居中
                inflater.layoutParams = layoutParams //占位
                layout_tab.addView(inflater) //添加布局
            }
        })
        //TODO 品牌制作商直供
        homeVM.brend.observe(this, Observer { brand ->
            //布局管理器
            recy_brand.layoutManager = GridLayoutManager(this,2)
            var brandAdapter =
                BrandAdapter(brand,this)
            //绑定适配器
            recy_brand.adapter = brandAdapter
        })

        //TODO 新品首发
        homeVM.newGoods.observe(this, Observer { newGood ->
            //布局管理器
            recy_newgood.layoutManager = GridLayoutManager(this,2)
            var newGoodsAdapter =
                NewGoodsAdapter(newGood,this)
            //绑定适配器
            recy_newgood.adapter = newGoodsAdapter
        })

        //TODO 人气推荐布局
        homeVM.hotGoods.observe(this, Observer { hotGoods ->
            //布局管理器
            recy_hotGoods.layoutManager = LinearLayoutManager(this)
            //分割线
            recy_hotGoods!!.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))
            var hotGoodsAdapter =
                HotGoodsAdapter(hotGoods,this)
            recy_hotGoods.adapter = hotGoodsAdapter
        })

        //TODO 专题精选
        homeVM.topic.observe(this, Observer { topic ->
            //布局管理器
            recy_topic.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
            var topicAdapter =
                TopicAdapter(topic,this)
            recy_topic.adapter = topicAdapter
        })
        //TODO 居家
        homeVM.category.observe(this, Observer { category->
            //循环放入布局
            for ((index,value)in category.withIndex()){
                var inflater = LayoutInflater.from(this).inflate(R.layout.fragment_home_item,null)
                inflater.txt_home_title.text = value.name
                var list = value.goodsList
                inflater.mRlv_home.layoutManager = GridLayoutManager(this,2)
                var categoryAdapter = CategoryAdapter(list,this)
                inflater.mRlv_home.adapter = categoryAdapter
                jujia.addView(inflater)
            }
        })
    }*/


    /*//显示banner
    private fun showBanner(banners:List<Banner>){
        banner_home!!.setImages(banners)
        banner_home!!.setImageLoader(MyBannerAdapter())
        banner_home!!.start()
    }

    //显示channel
    private fun showChannel(channel:List<Channel>){
        //清除所有布局
        layout_tab!!.removeAllViews()
        //权重
        val layoutParams = LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f)
        //循环  in修饰  indices 长度
        for (i in channel.indices){
            val inflat = LayoutInflater.from(this).inflate(R.layout.channel_item,null)
            inflat.channel_title.text = channel.get(i).name
            Glide.with(this).load(channel.get(i).icon_url).into(inflat.channel_img)
            inflat.channel_title.gravity = Gravity.CENTER  //文字居中
            inflat.layoutParams = layoutParams  //占位
            layout_tab.addView(inflat)   //添加布局
        }

    }

    //显示居家
    private fun showBrandData(brand:List<Brand>){
        //布局管理器
        recy_brand.layoutManager = GridLayoutManager(this,2)
        var brandAdapter = BrandAdapter(brand,this)
        recy_brand.adapter = brandAdapter
    }*/
    /*private fun loadHomeData() {
        var thread_name = Thread.currentThread().name
        MainScope().launch {
            var thread_name1 = Thread.currentThread().name
            var result = homeData()
            Log.i("TAG",result.errmsg)
            *//*showBanner(result.data.banner)
            showChannel(result.data.channel)
            showBrandData(result.data.brandList)*//*
        }
        Log.d("TAG","loadHomeData")
    }
    suspend fun homeData():HomeData{
        var url = "https://cdplay.cn/api/index"
        return get(url)
    }
    suspend fun get(netUrl:String)= withContext(Dispatchers.IO){
        var url = URL(netUrl)
        (url.openConnection()as? HttpsURLConnection).run {
            var sb = StringBuffer()
            var streamReader = InputStreamReader(this!!.inputStream,"utf-8")
            var reader = BufferedReader(streamReader)
            reader.use {
                var temp = reader.readLine()
                if (temp != null)sb.append(temp)
            }
            streamReader.close()
            reader.close()
            inputStream.close()
            val homeData = Gson().fromJson<HomeData>(sb.toString(),HomeData::class.java)
            return@run homeData
        }
    }*/
}