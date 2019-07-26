package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sampleangusapp.R
import com.example.sampleangusapp.internal.IdNotFoundException
import com.example.sampleangusapp.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.fragment_tenant_request_detail.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.factory

class TenantRequestDetailFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactoryInstanceFactory
            : ((Int) -> TenantRequestDetailViewModelFactory) by factory()
    private lateinit var viewModel: TenantRequestDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tenant_request_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val safeArgs = arguments?.let { TenantRequestDetailFragmentArgs.fromBundle(it) }
        val workOrderId = safeArgs?.id ?: throw IdNotFoundException()

        viewModel = ViewModelProviders.of(this, viewModelFactoryInstanceFactory(workOrderId))
            .get(TenantRequestDetailViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        val workOrder = viewModel.workOrder.await()

        workOrder.observe(this@TenantRequestDetailFragment, Observer { item ->
            if(item == null) return@Observer
            updateRequestTitle(item.workOrderTitle)
            updateStatus(item.workOrderStatus)
            updateAssignedTo("$item.assignedToFirstName ${item.assignedToLastName}")
            updateIds(item.assignedToEmployeeId, item.workOrderId!!)

        })
    }

    private fun updateRequestTitle(requestTitle: String) {
        title.text = requestTitle
    }

    private fun updateStatus(statusNum: Int) {
        if(statusNum == 1) {
            status.text = "Open"
        } else {
            status.text = "Closed"
        }
    }

    private fun updateAssignedTo(name: String) {
        assignedToText.text = name
    }

    private fun updateIds(employeeId: Int, workOrderId: Int) {
        employeeIdText.text = employeeId.toString()
        workOrderDisplayID.text = workOrderId.toString()
    }



}
