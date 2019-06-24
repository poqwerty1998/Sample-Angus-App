package com.example.samplelogin.ui.mainmenu.work.tenantrequest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class TenantRequestFragment : Fragment() {

    companion object {
        fun newInstance() = TenantRequestFragment()
    }

    private lateinit var viewModel: TenantRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tenant_request_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TenantRequestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
