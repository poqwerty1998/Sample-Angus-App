package com.example.sampleangusapp.data.network

/*import com.example.sampleangusapp.data.entity.LoginResponse*/
import com.example.sampleangusapp.data.entity.WorkOrder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://dev5.angus-systems.com/"

interface AngusApiService {
    
/*    @FormUrlEncoded
    @POST("employeeapi/v1/mobile/login/")
    fun validateLogin(
        @Field("userName") userName: String,
        @Field("password") password: String,
        @Field("domain") domain: String = "",
        @Field("userAgent") userAgent: String = "Postman",
        @Field("version") version: String = "2.23.0.48"
    ): Deferred<LoginResponse>*/

    @GET("employeeapi/v1/equipment/workorders")
    fun getWorkOrders(
        /*@Header("Authorization") auth: String,*/
        @Query("equipmentId") equipmentId: Int
    ): Deferred<List<WorkOrder>>

    companion object {
        /*private var credentials: String = ""*/
        private var credentials: String = Credentials.basic("angusdemo\\nicole", "qwerty")

        fun setCredentials(username: String, password: String) {
            this.credentials = Credentials.basic("angusdemo\\$username", password)
        }
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): AngusApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val original = chain.request()
                    val requestBuilder = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Authorization", credentials)
                        .method(original.method(), original.body())

                    val request = requestBuilder.build()

                    chain.proceed(request)
                }.addInterceptor(connectivityInterceptor)
                .build()
            // create a retrofit instance only if it is null
            val retrofitInstance: AngusApiService by lazy {
                val retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofit.create(AngusApiService::class.java)
            }
            return retrofitInstance
        }
    }
}