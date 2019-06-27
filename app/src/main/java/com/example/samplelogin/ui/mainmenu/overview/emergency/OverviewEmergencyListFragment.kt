package com.example.samplelogin.ui.mainmenu.overview.emergency

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class OverviewEmergencyListFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewEmergencyListFragment()
    }

    private lateinit var viewModel: OverviewEmergencyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.emergency_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OverviewEmergencyListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
