package com.example.samplelogin.ui.mainmenu.overview.tenantrequest.scheduled

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class OverviewScheduledFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewScheduledFragment()
    }

    private lateinit var viewModelOverview: OverviewScheduledViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.scheduled_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelOverview = ViewModelProviders.of(this).get(OverviewScheduledViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
