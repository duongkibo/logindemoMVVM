package com.kibo.loginmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kibo.loginmvvm.model.LoginResult
import com.kibo.loginmvvm.model.LoginService
import com.kibo.loginmvvm.model.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel:ViewModel {
    private  val loginService:LoginService

    val loginData:MutableLiveData<LoginResult>
    constructor()
    {
        loginData = MutableLiveData()
        loginService = RetrofitUtils.createRetrofit("https://app.baomoiday.net/public/",LoginService::class.java)
    }
    fun login(  email:String,  pass:String): MutableLiveData<LoginResult>
    {
        val data = MutableLiveData<LoginResult>()
        loginService.login(email,pass).enqueue(object : Callback<LoginResult>
        {
            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
               if(response.isSuccessful && response.body()!=null)
               {
                   data.postValue(response.body())
               }
            }
            override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                data.postValue(null)
            }


        })
        return  data

    }
}