package com.example.samplelogin.ui.mainmenu.work.tenantrequest.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplelogin.R
import com.shopify.livedataktx.observe
import kotlinx.android.synthetic.main.item_tenant_request.*
import kotlinx.android.synthetic.main.item_tenant_request.view.*
import kotlinx.android.synthetic.main.tenant_request_fragment.*

class TenantRequestFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(TenantRequestViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tenant_request_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tenantRequestRecyclerView?.layoutManager = LinearLayoutManager(activity)
        tenantRequestRecyclerView?.adapter = TenantRequestAdapter(viewModel)

        viewModel._navigationLiveData.observe { navigation ->
            when (navigation) {
                is TenantNavigation.Request -> {
                    view.
                    Navigation.findNavController(view).navigate(R.id.tenantRequestDetailFragment)
                }
            }
        }

        /*tenantRequestCardView.setOnClickListener {
            *//*val nextAction =
                TenantRequestFragmentDirections.actionToTenantRequestDetail("tenant request description")*//*
            Navigation.findNavController(it).navigate(R.id.tenantRequestDetailFragment)
        }*/
    }

}
