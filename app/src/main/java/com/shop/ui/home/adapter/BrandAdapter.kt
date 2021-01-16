package com.shop.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shop.MyItemClick
import com.shop.R
import kotlinx.android.synthetic.main.activity_brand.view.tv_brand_name
import kotlinx.android.synthetic.main.layout_brand_item.view.*

class BrandAdapter(
    private val list: List<com.shop.ui.home.bean.Brand>, private val mContext: Context?) :
    RecyclerView.Adapter<BrandAdapter.ViewHolder>(){

    //定义ViewHolder
    class ViewHolder(item: View) :RecyclerView.ViewHolder(item)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandAdapter.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_brand_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size?:0
    }

    override fun onBindViewHolder(holder: BrandAdapter.ViewHolder, position: Int) {
        with(holder ?.itemView!!){
            val bean = list!!.get(position)
            tv_brand_name.text=bean!!.name
            tv_brand_floor_price.text=bean!!.floor_price+"元起"
            if (mContext != null) {
                Glide.with(mContext).load(bean!!.new_pic_url).into(iv_brand_img)
            }
        }
        //设置接口
        holder.itemView.setOnClickListener{
            myItemClick!!.onItemCilck(position)
        }
    }
    //定义条目回调接口
    private var myItemClick: MyItemClick? = null
    //set方法
    fun setOnItemClick(myItemClick: MyItemClick){
        this.myItemClick = myItemClick
    }

}