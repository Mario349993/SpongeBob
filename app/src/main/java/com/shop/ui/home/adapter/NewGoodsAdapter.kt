package com.shop.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shop.R
import kotlinx.android.synthetic.main.layout_newgoods_item.view.*

class NewGoodsAdapter(private val list: List<com.shop.ui.home.bean.NewGoods>, private val mContext: FragmentActivity?):
RecyclerView.Adapter<NewGoodsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewGoodsAdapter.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_newgoods_item,null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewGoodsAdapter.ViewHolder, position: Int) {
        //TODO 赋值
        with(holder?.itemView!!){
            val bean = list.get(position)
            tv_newgoods_name.text = bean.name
            tv_newgoods_retail_price.text = "￥"+bean.retail_price
            if (mContext != null) {
                Glide.with(mContext).load(bean.list_pic_url).into(iv_newgoods_img)
            }
        }
    }
    class ViewHolder (item: View):RecyclerView.ViewHolder(item)
}