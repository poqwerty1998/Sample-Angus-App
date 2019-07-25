package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleangusapp.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sampleangusapp.data.entity.WorkOrder
import com.example.sampleangusapp.data.network.RetrofitClientInstance
import com.example.sampleangusapp.ui.base.ScopedFragment
import com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail.TenantRequestDetailFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_tenant_request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TenantRequestFragment : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()
    private val viewModelFactory: TenantRequestViewModelFactory by instance()

    private lateinit var viewModel: TenantRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tenant_request, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(TenantRequestViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        val workOrders = viewModel.workOrders.await()
        workOrders.observe(this@TenantRequestFragment, Observer { workOrderEntries ->
            if(workOrderEntries == null) return@Observer
            group_loading.visibility = View.GONE

            initRecyclerView(workOrderEntries.toTenantRequestItems())
        })
    }

    private fun List<WorkOrder>.toTenantRequestItems(): List<TenantRequestItem> {
        return this.map {
            TenantRequestItem(it)
        }
    }

    private fun initRecyclerView(items: List<TenantRequestItem>) {
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(items)
        }

        tenantRequestRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TenantRequestFragment.context)
            adapter = groupAdapter
        }

        /*groupAdapter.setOnItemClickListener { item, view ->
            *//*if(request.workOrderStatus == 1) {
                TenantRequestDetailFragment.setStatus("Open")
            } else {
                TenantRequestDetailFragment.setStatus("Closed")
            }
            TenantRequestDetailFragment.setTitle(request.workOrderTitle)
            TenantRequestDetailFragment.setDescription(task[0].description)
            TenantRequestDetailFragment.setETA(task[0].minutesEstimated.toString())
            TenantRequestDetailFragment.setAssignedTo(name)
            TenantRequestDetailFragment.setEmployeeId(request.assignedToEmployeeId.toString())
            TenantRequestDetailFragment.setDisplayId(request.displayId)
            Navigation.findNavController(it).navigate(R.id.tenantRequestDetailFragment)*//*
        }*/
    }

}
