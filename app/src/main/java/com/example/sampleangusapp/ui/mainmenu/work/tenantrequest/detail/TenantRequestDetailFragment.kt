package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R
import kotlinx.android.synthetic.main.fragment_tenant_request_detail.*
import kotlinx.android.synthetic.main.fragment_tenant_request_detail.view.*

class TenantRequestDetailFragment : Fragment() {

    companion object {
        private var requestTitle: String = ""
        private var requestStatus: String = ""
        private var requestDescription: String = ""
        private var eta: String = ""
        private var assignedTo: String = ""
        private var employeeId: String = ""
        private var displayId: String = ""

        fun setTitle(title: String) {
            this.requestTitle = title
        }

        fun setStatus(status: String) {
            this.requestStatus = status
        }

        fun setDescription(description: String) {
            this.requestDescription = description
        }

        fun setETA(eta: String) {
            this.eta = eta
        }

        fun setAssignedTo(assignedTo: String) {
            this.assignedTo = assignedTo
        }

        fun setEmployeeId(employeeId: String) {
            this.employeeId = employeeId
        }

        fun setDisplayId(displayId: String) {
            this.displayId = displayId
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tenant_request_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tenantRequestDetailFragment.title.text = requestTitle
        tenantRequestDetailFragment.status.text = requestStatus
        tenantRequestDetailFragment.description.text = requestDescription
        tenantRequestDetailFragment.estimatedMinutes.text = eta
        tenantRequestDetailFragment.employeeAssignedTo.text = assignedTo
        tenantRequestDetailFragment.employeeAssignedToID.text = employeeId
        tenantRequestDetailFragment.workOrderDisplayID.text = displayId
    }

}
