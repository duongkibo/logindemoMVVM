package com.kibo.loginmvvm.model

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import java.util.*

interface LoginService {
    @POST("api/auth/login")
    fun login(
        @Field( "email") email:String,
        @Field("password")  pass:String
    ):Call<LoginResult>
}