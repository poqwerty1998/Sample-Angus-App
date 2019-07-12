package com.example.sampleangusapp.ui.mainmenu.work.preventivemaintenance.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleangusapp.R
import kotlinx.android.synthetic.main.fragment_preventive_maintenance.*

class PreventiveMaintenanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_preventive_maintenance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preventiveMaintenanceRecyclerView?.layoutManager = LinearLayoutManager(activity)
        preventiveMaintenanceRecyclerView?.adapter =
            PreventiveMaintenanceAdapter()
    }

}
