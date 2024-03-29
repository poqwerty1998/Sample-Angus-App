package com.example.sampleangusapp

import androidx.test.filters.LargeTest
import com.example.sampleangusapp.data.entity.LoginResponse
import com.example.sampleangusapp.data.entity.WorkOrder
import com.example.sampleangusapp.data.network.RetrofitClientInstance
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertEquals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@LargeTest
class UnitTesting {
    // retrofit client post request
    @Test
    fun loginValidationPass() {
        val domain = ""
        val username = "nicole"
        val password = "qwerty"
        val userAgent = "Postman"
        val version = "2.23.0.48"
        RetrofitClientInstance.setCredentials("nicole", "password")
        RetrofitClientInstance.retrofitInstance.validateLogin(
            domain,
            username,
            password,
            userAgent,
            version
        ).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    // check if some fields in the object returned are as expected
                    assertEquals(loginResponse?.userName, "nicole")
                    assertEquals(loginResponse?.realName, "Nicole ahadi")
                    assertEquals(loginResponse?.employeeID, 1100000003)
                    assertEquals(loginResponse?.companyID, 5004)
                }
            }

        })
    }

    @Test
    fun loginValidationFail() {
        val domain = ""
        val username = "username"
        val password = "password"
        val userAgent = "Postman"
        val version = "2.23.0.48"
        RetrofitClientInstance.retrofitInstance.validateLogin(
            domain,
            username,
            password,
            userAgent,
            version
        ).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // insert assert here
            }
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse = response.body()
                assertEquals(loginResponse?.userName, null)
            }

        })
    }

    // retrofit client get request
    @Test
    fun getTenantRequestsPass() {
        runBlocking {
            RetrofitClientInstance.setCredentials("nicole", "qwerty")
            val workOrderList = RetrofitClientInstance.retrofitInstance.getWorkOrders(1100000005).await()
            val workOrder = workOrderList[0]
            assertEquals(workOrder.id, 22702152)
            assertEquals(workOrder.workOrderTitle, "Boiler General Maintenance")
            assertEquals(workOrder.assignedToEmployeeId, 311)
            assertEquals(workOrder.assignedToFirstName, "Max")
            assertEquals(workOrder.assignedToLastName, "Power")
        }
    }

    // retrofit client get request
    @Test
    fun getTenantRequestsFail() {
        runBlocking {
            RetrofitClientInstance.setCredentials("username", "password")
            val workOrderList = RetrofitClientInstance.retrofitInstance.getWorkOrders(1100000005).await()
            assertEquals(workOrderList, null)
        }
    }

    // api service

    // see if the values from get request contain correct values


}
