package com.example.samplelogin.ui.mainmenu.work.preventivemaintenance.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.samplelogin.R
import com.example.samplelogin.ui.mainmenu.work.tenantrequest.list.TenantRequestFragmentDirections
import kotlinx.android.synthetic.main.activity_my_work.view.*
import kotlinx.android.synthetic.main.item_preventive_maintenance.view.*
import kotlinx.android.synthetic.main.item_preventive_maintenance.view.buildingName
import kotlinx.android.synthetic.main.item_preventive_maintenance.view.employeeName
import kotlinx.android.synthetic.main.item_preventive_maintenance.view.propertyName
import kotlinx.android.synthetic.main.item_preventive_maintenance.view.requestId
import kotlinx.android.synthetic.main.item_tenant_request.view.*

class PreventiveMaintenanceAdapter(
    //val preventiveMaintenanceList: List<PreventiveMaintenanceItem>
) : RecyclerView.Adapter<PreventiveMaintenanceAdapter.PreventiveMaintenanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreventiveMaintenanceViewHolder {
        return PreventiveMaintenanceViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_preventive_maintenance, parent, false)
        )
    }

    //override fun getItemCount() = preventiveMaintenanceList.size
    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: PreventiveMaintenanceViewHolder, position: Int) {
        /*val request = tenantRequests[position]
        holder.view.requestDescription.text = request.requestDescription
        holder.view.propertyName.text = request.propertyName
        holder.view.buildingName.text = request.buildingName
        holder.view.employeeName.text = request.employeeName
        holder.view.requestId.text = request.requestId.toString()*/

        /*Glide.with(holder.view.context) use if the individual items need an image
            .load()*/

        holder.view.description.text = "dummy description preventive maintenance"
        holder.view.propertyName.text = "sample property"
        holder.view.buildingName.text = "sample building name"
        holder.view.employeeName.text = "sample employee name"
        holder.view.requestId.text = "12345678"
        holder.view.preventiveMaintenanceCardView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.preventiveMaintenanceDetailFragment)
        }
    }

    class PreventiveMaintenanceViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}