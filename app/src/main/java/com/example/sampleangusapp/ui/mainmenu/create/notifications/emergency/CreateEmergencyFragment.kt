package com.example.sampleangusapp.ui.mainmenu.create.notifications.emergency

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class CreateEmergencyFragment : Fragment() {

    companion object {
        fun newInstance() = CreateEmergencyFragment()
    }

    private lateinit var viewModel: CreateEmergencyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_emergency, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateEmergencyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
