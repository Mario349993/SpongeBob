package com.shop.ui.home.type

import android.annotation.SuppressLint
import android.util.Log
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.base.IItemClick
import com.shop.databinding.FragmentTypeInfoBinding
import com.shop.ui.home.adapter.TypeInfoAdapter
import com.shop.ui.home.bean.type.TypeSubCategory
import com.shop.viewmodel.TypeViewModel
import kotlinx.android.synthetic.main.fragment_type_info.*

class TypeInfoFragment : BaseFragment<TypeViewModel, FragmentTypeInfoBinding>
    (R.layout.fragment_type_info, TypeViewModel::class.java){
    var categroy: TypeInfoAdapter? = null

    var list : MutableList<TypeSubCategory> = mutableListOf()

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
//        goodListArr.put(R.layout.layout_type_item,BR.vmtypeinfoList)

        //设置适配器
        categroy = TypeInfoAdapter(context!!,list,goodListArr,itemClick())
        //绑定适配器
        mDataBinding!!.mRlvInfo.adapter = categroy
    }

    inner class itemClick:IItemClick<TypeSubCategory>{
        override fun itemClick(data: TypeSubCategory) {

            Log.e("TAG",data!!.name)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun initVM() {
        mViewModel.gettype_info.observe(this, Observer {
            Log.e("TAG", "initData: "+it.get(0).name)
//            if(it.size>0 && it!=null){
//                for (i in it){
//                    categroy!!.refreshData(it)
//                    Glide.with(context!!).load(it.get(0).banner_url).into(iv_typeinfo_head_img)
//                    tv_typeinfo_head_desc.text = it.get(0).front_name
//                    tv_typeinfo_title.text = it.get(0).name+"分类"
//                }
//            }else{
//                Log.e("TAG", "initVM: "+"无数据")
//            }
        })
    }

    override fun initData() {
        val id = arguments?.getInt("id")
        if (id != null){
            mViewModel.getTypeInfo(id)
            Log.e("TAG", "initData: "+id )
        }
    }

    override fun initVariable() {

    }

}