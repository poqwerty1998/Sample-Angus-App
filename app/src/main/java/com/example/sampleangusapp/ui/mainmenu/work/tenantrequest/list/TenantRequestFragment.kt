package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleangusapp.R
import androidx.fragment.app.Fragment
import com.example.sampleangusapp.data.entity.WorkOrder
import com.example.sampleangusapp.data.network.RetrofitClientInstance
import com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail.TenantRequestDetailFragment
import kotlinx.android.synthetic.main.fragment_tenant_request.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TenantRequestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tenant_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tenantRequestRecyclerView?.layoutManager = LinearLayoutManager(activity)
        // call get request to populate the recyclerview
        RetrofitClientInstance.retrofitInstance.getWorkOrders("1100000005")
            .enqueue(object : Callback<List<WorkOrder>> {
                override fun onFailure(call: Call<List<WorkOrder>>, t: Throwable) {
                    Toast.makeText(activity,
                        "Something wrong with retrieving data from the server.", Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<List<WorkOrder>>, response: Response<List<WorkOrder>>) {
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
