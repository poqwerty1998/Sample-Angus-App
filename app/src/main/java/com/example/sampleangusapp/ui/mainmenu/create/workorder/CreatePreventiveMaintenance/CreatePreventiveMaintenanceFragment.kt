package com.example.sampleangusapp.ui.mainmenu.create.workorder.CreatePreventiveMaintenance

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class CreatePreventiveMaintenanceFragment : Fragment() {

    companion object {
        fun newInstance() = CreatePreventiveMaintenanceFragment()
    }

    private lateinit var viewModel: CreatePreventiveMaintenanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_preventive_maintenance, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreatePreventiveMaintenanceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
