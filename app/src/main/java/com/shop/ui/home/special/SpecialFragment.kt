package com.shop.ui.home.special

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shop.R


class SpecialFragment : Fragment() {

    //采用伴生对象 companion object==static
    companion object{
        val instance by lazy { SpecialFragment() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_special, container, false)
        return inflate
    }

}