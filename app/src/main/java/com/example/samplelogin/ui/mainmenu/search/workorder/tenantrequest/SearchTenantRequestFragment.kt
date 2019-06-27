package com.example.samplelogin.ui.mainmenu.search.workorder.tenantrequest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplelogin.R

class SearchTenantRequestFragment : Fragment() {

    companion object {
        fun newInstance() = SearchTenantRequestFragment()
    }

    private lateinit var viewModel: SearchTenantRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_tenant_request_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchTenantRequestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
