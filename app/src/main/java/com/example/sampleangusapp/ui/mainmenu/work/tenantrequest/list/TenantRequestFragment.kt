package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleangusapp.R
import androidx.fragment.app.Fragment
import com.example.sampleangusapp.data.entity.WorkOrderList
import com.example.sampleangusapp.data.network.RetrofitClientInstance
import kotlinx.android.synthetic.main.tenant_request_fragment.*
import okhttp3.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TenantRequestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tenant_request_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tenantRequestRecyclerView?.layoutManager = LinearLayoutManager(activity)
        // call get request to populate the recyclerview
        RetrofitClientInstance.retrofitInstance.getWorkOrders("1100000005")
            .enqueue(object : Callback<WorkOrderList> {
                override fun onFailure(call: Call<WorkOrderList>, t: Throwable) {
                    Toast.makeText(activity,
                        "Something wrong with retrieving data from the server.", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<WorkOrderList>, response: Response<WorkOrderList>) {
                    if(response.isSuccessful) {
                        val workOrderList = response.body()
                        tenantRequestRecyclerView?.adapter = TenantRequestAdapter(workOrderList!!)
                    } else {
                        Toast.makeText(activity,
                            "Something wrong with retrieving data from the server.", Toast.LENGTH_LONG).show()
                    }
                }

            })
    }

}
