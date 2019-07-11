package com.example.sampleangusapp.data.network

import okhttp3.Authenticator
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.Route
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://dev5.angus-systems.com/"

object RetrofitClientInstance {
    private var credentials: String = ""

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            println("::::::::::::::::::::::::$credentials:::::::::::::::::::::::::")
            val requestBuilder = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", credentials)
                .method(original.method(), original.body())

            val request = requestBuilder.build()

            chain.proceed(request)
        }/*.authenticator { _, response ->
            response.request()
                .newBuilder()
                .header("Authorization", credentials)
                .build()
        }*/.build()


    // create a retrofit instance only if it is null
    val retrofitInstance: AngusApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(AngusApiService::class.java)
    }

    fun setCredentials(username: String, password: String) {
        this.credentials = Credentials.basic("angusdemo\\$username", password)
    }
}