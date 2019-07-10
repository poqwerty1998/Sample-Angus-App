package com.example.sampleangusapp.ui.mainmenu.overview.tenantrequest.completed

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class OverviewCompletedFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewCompletedFragment()
    }

    private lateinit var viewModel: OverviewCompletedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.completed_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OverviewCompletedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
