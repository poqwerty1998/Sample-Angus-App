package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleangusapp.R
import com.example.sampleangusapp.data.entity.WorkOrder
import com.example.sampleangusapp.data.entity.WorkOrderList
import kotlinx.android.synthetic.main.item_tenant_request.view.*

class TenantRequestAdapter(
    private val workOrderList: WorkOrderList
) : RecyclerView.Adapter<TenantRequestAdapter.TenantRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenantRequestViewHolder {
        return TenantRequestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tenant_request, parent, false)
        )
    }
    override fun getItemCount() = workOrderList.workOrders.size

    override fun onBindViewHolder(holder: TenantRequestViewHolder, position: Int) {
        val request = workOrderList.workOrders[position]
        val name = request.assignedToFirstName + request.assignedToLastName
        /*Glide.with(holder.view.context) use if the individual items need an image
            .load()*/
        holder.view.workOrderTitle.text = request.workOrderTitle
        holder.view.employeeName.text = name
        holder.view.employeeId.text = request.assignedToEmployeeId.toString()
        holder.view.displayId.text = request.displayId
        holder.view.tenantRequestCardView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.tenantRequestDetailFragment)
        }
    }

    class TenantRequestViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}