package com.example.sampleangusapp.ui.mainmenu.overview.tenantrequest.escalated

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class OverviewEscalatedFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewEscalatedFragment()
    }

    private lateinit var viewModel: OverviewEscalatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_escalated, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OverviewEscalatedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
