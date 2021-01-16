package com.shop.ui.login

import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection

sealed class Result<out R>{
    data class Success<out T>(val data:T):Result<T>()
    data class Error(val exception:Exception):Result<Nothing>()

}

class LoginRepository() {

    private val home_url = "https://cdplay.cn/api/index"
    fun home(
        jsonBody:String
    ):Result<String>{
        val url = URL(home_url)
        (url.openConnection() as? HttpsURLConnection)?.run {
            requestMethod = "GET"
            setRequestProperty("Content-Type","application/json;utf-8")
            setRequestProperty("Accept","application/json")
            doOutput = true
            outputStream.write(jsonBody.toByteArray())
            return Result.Success(outputStream.toString())
        }
        return Result.Error(Exception("Cannot open HttpURLConnection"))
    }

}