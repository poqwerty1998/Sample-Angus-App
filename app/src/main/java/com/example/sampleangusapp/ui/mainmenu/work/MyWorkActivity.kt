package com.example.sampleangusapp.ui.mainmenu.work

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.sampleangusapp.R
import kotlinx.android.synthetic.main.activity_my_work.*
import android.view.MenuItem
import android.widget.Toast
import com.example.sampleangusapp.data.entity.WorkOrderList
import com.example.sampleangusapp.data.network.RetrofitClientInstance
import com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list.TenantRequestItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyWorkActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_work)

        setSupportActionBar(toolbar)
        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottom_nav?.setupWithNavController(navController)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home ->  {
                onBackPressed()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadworkOrders() {
        RetrofitClientInstance.retrofitInstance.getWorkOrders("110000005")
            .enqueue(object : Callback<WorkOrderList> {
                override fun onFailure(call: Call<WorkOrderList>, t: Throwable) {
                    Toast.makeText(applicationContext,
                        "Something wrong with retrieving data from the server.", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<WorkOrderList>, response: Response<WorkOrderList>) {
                    if(response.isSuccessful) {
                        val workOrderList = response.body()
                        val tenantRequestItems: List<TenantRequestItem>
                    } else {
                        Toast.makeText(applicationContext,
                            "Something wrong with retrieving data from the server.", Toast.LENGTH_LONG).show()
                    }
                }

            })
        RetrofitClientInstance.setCredentials("", "")
    }
}