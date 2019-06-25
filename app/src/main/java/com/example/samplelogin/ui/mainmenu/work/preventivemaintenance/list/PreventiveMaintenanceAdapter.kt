package com.example.samplelogin.ui.mainmenu.work.preventivemaintenance.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplelogin.R
import kotlinx.android.synthetic.main.item_preventive_maintenance.view.*

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
    }

    class PreventiveMaintenanceViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}