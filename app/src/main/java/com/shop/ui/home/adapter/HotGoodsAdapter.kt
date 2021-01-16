package com.shop.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shop.R
import kotlinx.android.synthetic.main.layout_hotgoods_item.view.*

class HotGoodsAdapter(private val list: List<com.shop.ui.home.bean.HotGoods>, private val mContext: FragmentActivity?) :
    RecyclerView.Adapter<HotGoodsAdapter.ViewHolder>(){
    class ViewHolder(item: View) :RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_hotgoods_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO  赋值
        with(holder ?.itemView!!){
            val bean = list.get(position)
            tv_hotgoods_name.text=bean.name
            tv_hotgoods_goods_brief.text=bean.goods_brief
            tv_hotgoods_retail_price.text=bean.retail_price
            if (mContext != null) {
                Glide.with(mContext).load(bean.list_pic_url).into(iv_hotgoods_img)
            }
        }
    }

}