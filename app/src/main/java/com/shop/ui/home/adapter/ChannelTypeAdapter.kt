package com.shop.ui.home.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myshop.model.bean.shop.home.channel.ChannelTreeDataX
import com.shop.R
import kotlinx.android.synthetic.main.layout_channel_item_one.view.*


class ChannelTypeAdapter (private val datalist: List<ChannelTreeDataX>, private val mContext: Context?)
    : RecyclerView.Adapter<ChannelTypeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelTypeAdapter.ViewHolder {
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_channel_item_one, null)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return datalist?.size?:0
    }

    override fun onBindViewHolder(holder: ChannelTypeAdapter.ViewHolder, position: Int) {
        with(holder?.itemView!!){
            tv_channel1_name!!.text = datalist!!.get(position)!!.name
            tv_channel1_price!!.text = datalist!!.get(position)!!.retail_price+"元起"
            Glide.with(mContext!!).load(datalist!!.get(position)!!.list_pic_url).into(iv_channel1_img)
        }
    }

    //定义ViewHolder    名字 : 类型
    class ViewHolder(item: View):RecyclerView.ViewHolder(item)
}