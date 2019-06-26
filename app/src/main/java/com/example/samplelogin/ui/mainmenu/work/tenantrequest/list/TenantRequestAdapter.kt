package com.example.samplelogin.ui.mainmenu.work.tenantrequest.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplelogin.R
import kotlinx.android.synthetic.main.item_tenant_request.view.*

class TenantRequestAdapter(
    //val tenantRequests: List<TenantRequestItem>
    val tenantRequestViewModel: TenantRequestViewModel
) : RecyclerView.Adapter<TenantRequestAdapter.TenantRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenantRequestViewHolder {
        return TenantRequestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tenant_request, parent, false)
                .apply {
                    tenantRequestCardView.setOnClickListener {
                        tenantRequestViewModel.onRequestClicked(10)
                    }
                }
        )
    }

    //override fun getItemCount() = tenantRequests.size
    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: TenantRequestViewHolder, position: Int) {
        /*val request = tenantRequests[position]
        holder.view.requestDescription.text = request.requestDescription
        holder.view.propertyName.text = request.propertyName
        holder.view.buildingName.text = request.buildingName
        holder.view.employeeName.text = request.employeeName
        holder.view.requestId.text = request.requestId.toString()*/

        /*Glide.with(holder.view.context) use if the individual items need an image
            .load()*/

        holder.view.requestDescription.text = "dummy description tenant request"
        holder.view.propertyName.text = "sample property"
        holder.view.buildingName.text = "sample building name"
        holder.view.employeeName.text = "sample employee name"
        holder.view.requestId.text = "12345678"
    }

    class TenantRequestViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}