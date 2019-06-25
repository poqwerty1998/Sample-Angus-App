package com.example.samplelogin.ui.mainmenu.work.tenantrequest.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.samplelogin.R
import kotlinx.android.synthetic.main.tenant_request_fragment.*

class TenantRequestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tenant_request_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tenantRequestRecyclerView?.layoutManager = LinearLayoutManager(activity)
        tenantRequestRecyclerView?.adapter =
            TenantRequestAdapter()
    }

}
