package com.example.sampleangusapp.data.network

import com.example.sampleangusapp.data.entity.LoginResponse
import com.example.sampleangusapp.data.entity.WorkOrderList
import retrofit2.Call
import retrofit2.http.*

interface AngusApiService {

    @FormUrlEncoded
    @POST("employeeapi/v1/mobile/login/")
    fun validateLogin(
        @Field("domain") domain: String,
        @Field("userName") userName: String,
        @Field("password") password: String,
        @Field("userAgent") userAgent: String,
        @Field("version") version: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @GET("employeeapi/v1/equipment/workorders?equipmentId=1100000005")
    fun getWorkOrders(
        @Query("equipmentId") equipmentId: String
    ): Call<WorkOrderList>
}