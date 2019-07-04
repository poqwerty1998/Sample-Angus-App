package com.example.samplelogin.data

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginValidate {

    @FormUrlEncoded
    @POST("login")
    fun validate(
        @Field("userName") userName: String,
        @Field("password") password: String
    ): Call<UserDetails>
}