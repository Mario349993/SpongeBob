package com.shop.ui.home.type

import android.util.Log
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.shop.BR
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.base.IItemClick
import com.shop.databinding.FragmentTypeInfoBinding
import com.shop.ui.home.adapter.TypeInfoAdapter
import com.shop.ui.home.bean.type.TypeInfoBean
import com.shop.viewmodel.TypeViewModel
import kotlinx.android.synthetic.main.fragment_type_info.*

class TypeInfoFragment : BaseFragment<TypeViewModel, FragmentTypeInfoBinding>
    (R.layout.fragment_type_info, TypeViewModel::class.java){
    var categroy: TypeInfoAdapter? = null

    var list : MutableList<TypeInfoBean.SubCategory> = mutableListOf()

    //采用伴生对象
    companion object{
        val instance : TypeInfoFragment by lazy { TypeInfoFragment() }
    }

    override fun initView() {
        val layoutManager = GridLayoutManager(activity,3)
        //设置布局管理器
        mDataBinding!!.mRlvInfo.layoutManager = layoutManager

        //获取子条目布局
        var goodListArr = SparseArray<Int>()
        goodListArr.put(R.layout.layout_type_item,BR.vmtypeinfoList)

        //设置适配器
        categroy = TypeInfoAdapter(context!!,list,goodListArr,itemClick())
        //绑定适配器
        mDataBinding!!.mRlvInfo.adapter = categroy
    }

    inner class itemClick:IItemClick<TypeInfoBean.SubCategory>{
        override fun itemClick(data: TypeInfoBean.SubCategory) {

            Log.e("TAG",data!!.name)
        }
    }

    override fun initVM() {
        mViewModel.gettype_info.observe(this, Observer {
            for (i in it.indices){
                Glide.with(context!!).load(it.get(i).banner_url).into(iv_typeinfo_head_img)
                tv_typeinfo_head_desc.setText(it.get(i).front_desc)
                tv_typeinfo_title.setText(it.get(i).name+"分类")
                categroy!!.refreshData(it.get(i).subCategoryList)
            }
        })
    }

    override fun initData() {
        val id = getArguments()?.getInt("id")
        if (id != null){
            mViewModel.getTypeInfo(id)
        }
    }

    override fun initVariable() {
    }

}