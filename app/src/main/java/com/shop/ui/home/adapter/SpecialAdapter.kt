package com.shop.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shop.BR
import com.shop.R
import com.shop.ui.home.BaseViewHolder
import com.shop.ui.home.bean.special.Data
import kotlinx.android.synthetic.main.fragment_special.view.*
import kotlinx.android.synthetic.main.layout_special_item.view.*

class SpecialAdapter
    (var context: Context?,var list: List<Data> = listOf<Data>())
    :RecyclerView.Adapter<BaseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),viewType,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        var binding:ViewDataBinding = holder.dataBinding
        //把数据绑定到item的xml界面
        binding.setVariable(BR.vmSpecial_item,list.get(position))

        with(holder?.itemView){
            Glide.with(context).load(list.get(position).scene_pic_url).into(binding.root.iv_special_img)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_special_item
    }

    /**
     * 加载完数据刷新到界面的data
     */
    fun refreshData(lt:List<Data>){
        list = lt
        notifyDataSetChanged()
    }
}