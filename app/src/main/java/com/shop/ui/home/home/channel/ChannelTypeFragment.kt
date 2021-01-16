package com.shop.ui.home.home.channel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myshop.model.bean.shop.home.channel.ChannelTreeDataX
import com.example.myshop.viewmodel.shop.home.channel.ChannelTypeViewModel
import com.shop.R
import com.shop.ui.home.adapter.ChannelTypeAdapter
import com.shop.utils.SpUtils
import kotlinx.android.synthetic.main.fragment_channel_type.*

class ChannelTypeFragment : Fragment() {

    lateinit var homeVM: ChannelTypeViewModel
    var title:String? = null
    var front_name:String? = null

    var id:Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_channel_type, container, false)

        title = arguments!!.getString("channel_name")
        front_name = arguments!!.getString("front_name")

        id = arguments!!.getInt("channel_id")
        //Sp保存id给ViewModel
        SpUtils.instance!!.setValue("channel_id",id)

        initVm()
        homeVM.loadChanneltreeData()
        return inflate
    }

    fun initVm(){

//        tv_channel1_title.setText(title)
//        tv_channel1_front_desc!!.text = front_name

        //初始化ViewModel
        homeVM = ViewModelProvider(this).get(ChannelTypeViewModel::class.java)
        //监听网络状态的变化
        homeVM.loadStatue.observe(this, Observer { status ->
            if (status == -1) {
                Log.e("TAG", "HomeChannelTreeFragment: "+"数据加载失败" )
            }
        })

        //监听底部rlv数据的变化
        homeVM.dataX.observe(this, Observer {
            //网格布局
            mRlv_channelType!!.layoutManager = GridLayoutManager(activity, 2)
            //分割线
            mRlv_channelType!!.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    LinearLayout.VERTICAL
                )
            )
            //val 不可变参数
            val data = arrayListOf<ChannelTreeDataX>()
            //添加值
            data.addAll(it)
            //设置适配器
            val homeTreeAdapter = ChannelTypeAdapter(data, activity)
            //绑定适配器
            mRlv_channelType!!.adapter = homeTreeAdapter
        })
    }
}