package com.example.sampleangusapp.ui.mainmenu.overview.tenantrequest.outstanding

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class OverviewOutstandingFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewOutstandingFragment()
    }

    private lateinit var viewModel: OverviewOutstandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_outstanding, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OverviewOutstandingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
