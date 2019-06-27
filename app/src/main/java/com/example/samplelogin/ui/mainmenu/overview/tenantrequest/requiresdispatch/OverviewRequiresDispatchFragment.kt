package com.example.samplelogin.ui.mainmenu.overview.tenantrequest.requiresdispatch

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class OverviewRequiresDispatchFragment : Fragment() {

    companion object {
        fun newInstance() =
            OverviewRequiresDispatchFragment()
    }

    private lateinit var viewModelOverview: OverviewRequiresDispatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.requires_dispatch_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelOverview = ViewModelProviders.of(this).get(OverviewRequiresDispatchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
