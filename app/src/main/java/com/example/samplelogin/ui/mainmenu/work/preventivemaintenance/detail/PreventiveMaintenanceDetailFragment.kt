package com.example.samplelogin.ui.mainmenu.work.preventivemaintenance.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class PreventiveMaintenanceDetailFragment : Fragment() {

    companion object {
        fun newInstance() = PreventiveMaintenanceDetailFragment()
    }

    private lateinit var viewModel: PreventiveMaintenanceDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.preventive_maintenance_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PreventiveMaintenanceDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
