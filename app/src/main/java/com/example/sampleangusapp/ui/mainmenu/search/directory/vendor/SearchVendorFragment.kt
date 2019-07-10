package com.example.sampleangusapp.ui.mainmenu.search.directory.vendor

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class SearchVendorFragment : Fragment() {

    companion object {
        fun newInstance() = SearchVendorFragment()
    }

    private lateinit var viewModel: SearchVendorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_vendor_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchVendorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
