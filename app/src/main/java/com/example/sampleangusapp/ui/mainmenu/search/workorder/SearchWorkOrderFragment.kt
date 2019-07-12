package com.example.sampleangusapp.ui.mainmenu.search.workorder

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class SearchWorkOrderFragment : Fragment() {

    companion object {
        fun newInstance() = SearchWorkOrderFragment()
    }

    private lateinit var viewModel: SearchWorkOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_work_order, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchWorkOrderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
