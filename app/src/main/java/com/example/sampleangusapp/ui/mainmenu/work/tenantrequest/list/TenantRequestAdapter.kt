package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleangusapp.R
import kotlinx.android.synthetic.main.item_tenant_request.view.*

class TenantRequestAdapter(
    private val tenantRequestItems: List<TenantRequestItem>
) : RecyclerView.Adapter<TenantRequestAdapter.TenantRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenantRequestViewHolder {
        return TenantRequestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tenant_request, parent, false)
        )

    }

    override fun getItemCount() = tenantRequestItems.size

    override fun onBindViewHolder(holder: TenantRequestViewHolder, position: Int) {
        val request = tenantRequestItems[position]


        /*Glide.with(holder.view.context) use if the individual items need an image
            .load()*/

        /*holder.view.requestDescription.text = "dummy description tenant request"
        holder.view.propertyName.text = "sample property"
        holder.view.buildingName.text = "sample building name"
        holder.view.employeeName.text = "sample employee name"
        holder.view.requestId.text = "12345678"*/
        holder.view.tenantRequestCardView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.tenantRequestDetailFragment)
        }
    }

    class TenantRequestViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}