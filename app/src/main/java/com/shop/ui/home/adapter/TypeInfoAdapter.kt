package com.shop.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.BR
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.ui.home.bean.type.TypeInfoBean

class TypeInfoAdapter(context: Context,
                      list:List<TypeInfoBean.SubCategory>,
                      layouts: SparseArray<Int>,
                      var click: IItemClick<TypeInfoBean.SubCategory>
)
    : BaseAdapter<TypeInfoBean.SubCategory>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_type_item
    }

    override fun bindData(binding: ViewDataBinding, data: TypeInfoBean.SubCategory, layId: Int) {
        binding.setVariable(BR.vmtypeinfoListClick,click)
    }
    //刷新token
    fun refreshData(lt:List<TypeInfoBean.SubCategory>){
        list = lt
        notifyDataSetChanged()
    }
}