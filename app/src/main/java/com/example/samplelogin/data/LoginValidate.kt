package com.example.samplelogin.data

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginValidate {

    @FormUrlEncoded
    @POST("employeeapi/v1/mobile/login/")
    fun validate(
        @Field("domain") domain: String,
        @Field("userName") userName: String,
        @Field("password") password: String,
        @Field("userAgent") userAgent: String,
        @Field("version") version: String
    ): Call<LoginResponse>
}