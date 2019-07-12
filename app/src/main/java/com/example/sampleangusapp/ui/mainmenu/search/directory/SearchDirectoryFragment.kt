package com.example.sampleangusapp.ui.mainmenu.search.directory

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R

class SearchDirectoryFragment : Fragment() {

    companion object {
        fun newInstance() = SearchDirectoryFragment()
    }

    private lateinit var viewModel: SearchDirectoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_directory, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchDirectoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
