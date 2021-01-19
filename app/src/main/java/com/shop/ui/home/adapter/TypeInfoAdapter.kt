package com.shop.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.shop.BR
import com.shop.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.ui.home.bean.type.TypeInfoBean
import com.shop.ui.home.bean.type.TypeSubCategory

class TypeInfoAdapter(context: Context,
                      list:List<TypeSubCategory>,
                      layouts: SparseArray<Int>,
                      var click: IItemClick<TypeSubCategory>
)
    : BaseAdapter<TypeSubCategory>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_type_item
    }

    override fun bindData(binding: ViewDataBinding, data: TypeSubCategory, layId: Int) {
        binding.setVariable(BR.vmtypeinfoListClick,click)
    }
    //刷新token
    fun refreshData(lt:List<TypeSubCategory>){
        list = lt
        notifyDataSetChanged()
    }
}