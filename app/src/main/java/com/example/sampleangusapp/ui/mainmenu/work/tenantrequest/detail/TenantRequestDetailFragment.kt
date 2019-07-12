package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sampleangusapp.R
import kotlinx.android.synthetic.main.fragment_tenant_request_detail.*
import kotlinx.android.synthetic.main.fragment_tenant_request_detail.view.*

class TenantRequestDetailFragment : Fragment() {
    private lateinit var viewModel: TenantRequestDetailViewModel
    private var description: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tenant_request_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tenantRequestDetailFragment.detail.text = description

    }
    fun setDescription(description: String) {
        this.description = description
    }
}
