package com.example.samplelogin.ui.mainmenu.create.workorder.CreateTenantRequest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class CreateTenantRequestFragment : Fragment() {

    companion object {
        fun newInstance() = CreateTenantRequestFragment()
    }

    private lateinit var viewModel: CreateTenantRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_tenant_request_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateTenantRequestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
