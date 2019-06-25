package com.example.samplelogin.ui.mainmenu.work.preventivemaintenance.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplelogin.R
import kotlinx.android.synthetic.main.preventive_maintenance_fragment.*

class PreventiveMaintenanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.preventive_maintenance_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preventiveMaintenanceRecyclerView?.layoutManager = LinearLayoutManager(activity)
        preventiveMaintenanceRecyclerView?.adapter =
            PreventiveMaintenanceAdapter()
    }

}
