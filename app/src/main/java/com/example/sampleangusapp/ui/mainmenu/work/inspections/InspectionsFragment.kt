package com.example.sampleangusapp.ui.mainmenu.work.inspections

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class InspectionsFragment : Fragment() {

    companion object {
        fun newInstance() = InspectionsFragment()
    }

    private lateinit var viewModel: InspectionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inspections, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InspectionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
