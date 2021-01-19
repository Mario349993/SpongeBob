package com.shop.ui.home.special

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shop.R
import com.shop.base.BaseFragment
import com.shop.databinding.FragmentSpecialBinding
import com.shop.ui.home.adapter.SpecialAdapter
import kotlinx.android.synthetic.main.fragment_special.*


class SpecialFragment : BaseFragment<SpecialViewModel,FragmentSpecialBinding>
    (R.layout.fragment_special,SpecialViewModel::class.java),View.OnClickListener{

    var special: SpecialAdapter? = null
    var page:Int? = null
    var ONE:Int = 1
    var TWO:Int = 2
    //采用伴生对象 companion object==static
    companion object{
        val instance: SpecialFragment by lazy { SpecialFragment() }
    }

    override fun initView() {
        val layoutManager = LinearLayoutManager(activity)
        //设置布局管理器
        mDataBinding!!.mRlvSpecial.layoutManager = layoutManager
        //设置适配器
        special = SpecialAdapter(context)
        //绑定适配器
        mDataBinding!!.mRlvSpecial.adapter = special
        initClick()
    }
    private fun initClick(){
        mDataBinding!!.btnPreviousPage.setOnClickListener(this)
        mDataBinding!!.btnNextPage.setOnClickListener(this)
    }



    override fun initVM() {
        initSpecial()
    }
    private fun initSpecial(){
        mViewModel!!.special.observe(this, Observer {
            //隐藏加载中
            tv_special_oading!!.visibility = View.GONE
            iv_special_all!!.visibility = View.GONE
            special!!.refreshData(it)//进行加载数据
        })
    }

    override fun initData() {
        page = ONE
        mViewModel.getSpecial(page!!)
    }

    override fun initVariable() {

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_previous_page->{
                //更换page页
                page = ONE
                //显示加载中
                tv_special_oading!!.visibility = View.VISIBLE
                iv_special_all!!.visibility = View.VISIBLE
                //获取专题的数据
                mViewModel.getSpecial(page!!)
                //返回顶部
                mNsv_special!!.fullScroll(ScrollView.FOCUS_UP)
            }
            R.id.btn_next_page->{
                //更换page页
                page = TWO
                //显示加载中
                tv_special_oading!!.visibility = View.VISIBLE
                iv_special_all!!.visibility = View.VISIBLE
                //获取专题的数据
                mViewModel.getSpecial(page!!)
                //返回顶部
                mNsv_special!!.fullScroll(ScrollView.FOCUS_UP)
            }
        }
    }

}