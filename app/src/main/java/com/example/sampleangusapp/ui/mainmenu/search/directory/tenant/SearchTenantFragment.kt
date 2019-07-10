package com.example.sampleangusapp.ui.mainmenu.search.directory.tenant

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class SearchTenantFragment : Fragment() {

    companion object {
        fun newInstance() = SearchTenantFragment()
    }

    private lateinit var viewModel: SearchTenantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_tenant_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchTenantViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
