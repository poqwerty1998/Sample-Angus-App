package com.example.sampleangusapp.ui.mainmenu.search.directory.contact

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class SearchContactFragment : Fragment() {

    companion object {
        fun newInstance() = SearchContactFragment()
    }

    private lateinit var viewModel: SearchContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_contact, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchContactViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
