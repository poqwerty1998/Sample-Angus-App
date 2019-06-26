package com.example.samplelogin.ui.mainmenu.work.tenantrequest.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.samplelogin.R
import kotlinx.android.synthetic.main.item_tenant_request.*
import kotlinx.android.synthetic.main.tenant_request_detail_fragment.*
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
        tenantRequestRecyclerView?.adapter = TenantRequestAdapter()

        /*tenantRequestCardView.setOnClickListener {
            *//*val nextAction =
                TenantRequestFragmentDirections.actionToTenantRequestDetail("tenant request description")*//*
            Navigation.findNavController(it).navigate(R.id.tenantRequestDetailFragment)
        }*/
    }

    private fun showTenantRequestDetail(request: TenantRequestItem, view: View) {
        val requestId = request.requestId.toString()
            // pass information to know which item was clicked to show the details of it
        val detailString = request.requestDescription

    }

}
