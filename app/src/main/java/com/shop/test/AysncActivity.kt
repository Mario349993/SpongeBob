package com.shop.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shop.R
import kotlinx.coroutines.*
import java.net.URL
import kotlin.coroutines.CoroutineContext

class AysncActivity : AppCompatActivity(),CoroutineScope{

    lateinit var job: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aysnc)
        job = Job()
        loadData()

        //创建一个协程
        GlobalScope.launch {
            //耗时操作
        }
    }

    private fun loadData() = launch {
        val ioData = async(Dispatchers.IO){
            var result = URL("https://cdplay.cn/api/index").readText(charset("utf-8"))
            return@async result
        }
        val data = ioData.await() //等待阻塞i/o操作结果返回
        Log.i("TAG",data)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main+job

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}