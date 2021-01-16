package com.shop.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginViewModel(
        private val loginRepository: LoginRepository
):ViewModel() {
    fun login(username:String,password:String){
        Log.d("TAG","当前的线程："+Thread.currentThread().name)
        val body = "{username:\"$username\",password:\"$password\"}"
        loginRepository.home(body)

        //创建携程
        viewModelScope.launch(Dispatchers.IO){
            Log.d("TAG",Thread.currentThread().name)
            val jsonBody = "{username:\"$username\",password:\"$password\"}"
            val result = try {
                loginRepository.home(jsonBody)
            }catch (e:Exception){
                Result.Error(Exception("Newwork request failed"))
            }
            when(result){
                is Result.Success<String> -> Log.d("TAG",result.data)
                else -> Log.d("TAG",result.toString())
            }
        }


    }

    //suspend强制从携程内调用函数
    suspend fun home(){
        //携程执行完切换到其他线程  withContext主线程安全
        return withContext(Dispatchers.IO){

        }
    }
}