package com.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
    }
    fun test(){
        val sum:(Int,Int)->Int={a,b->a+b}
        print(sum(1,2))

        var a = 1
        //模板中的简单名称
        var s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is","was")},but now is $a"
        print(s2)
        var arr = arrayOf(1,2,3,4)
        arr.forEach {
            var b = it
            print(b)
        }
    }
}