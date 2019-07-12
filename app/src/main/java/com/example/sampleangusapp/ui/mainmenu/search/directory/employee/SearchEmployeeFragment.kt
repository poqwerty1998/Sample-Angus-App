package com.example.sampleangusapp.ui.mainmenu.search.directory.employee

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class SearchEmployeeFragment : Fragment() {

    companion object {
        fun newInstance() = SearchEmployeeFragment()
    }

    private lateinit var viewModel: SearchEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_employee, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchEmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
