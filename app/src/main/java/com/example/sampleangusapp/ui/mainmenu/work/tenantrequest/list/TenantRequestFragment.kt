package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleangusapp.R
import androidx.fragment.app.Fragment
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

        //maybe do http get in here so there's something to pass into the adapter

        /*tenantRequestRecyclerView?.adapter = TenantRequestAdapter()*/
        // type 1 is for TR, type 2 is for PM
    }

}
