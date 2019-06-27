package com.example.samplelogin.ui.mainmenu.overview.tenantrequest.outstanding

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class OverviewOutstandingFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewOutstandingFragment()
    }

    private lateinit var viewModel: OverviewOutstandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.outstanding_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OverviewOutstandingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
