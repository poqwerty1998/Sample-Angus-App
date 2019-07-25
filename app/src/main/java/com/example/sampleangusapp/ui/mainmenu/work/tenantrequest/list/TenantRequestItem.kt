package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import android.annotation.SuppressLint
import com.example.sampleangusapp.R
import com.example.sampleangusapp.data.entity.WorkOrder
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_tenant_request.*

class TenantRequestItem(
    val tenantRequestEntry: WorkOrder
) : Item() {
    @SuppressLint("SetTextI18n")
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            workOrderTitle.text = tenantRequestEntry.workOrderTitle
            employeeName.text = "${tenantRequestEntry.assignedToFirstName} ${tenantRequestEntry.assignedToLastName}"
            employeeId.text = tenantRequestEntry.assignedToEmployeeId.toString()
            displayId.text = tenantRequestEntry.displayId
        }
    }

    override fun getLayout() = R.layout.item_tenant_request
}