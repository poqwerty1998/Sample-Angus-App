package com.example.samplelogin.ui.mainmenu.work.tenantrequest.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplelogin.R
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.shopify.livedataktx.observe
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
        tenantRequestRecyclerView?.adapter = TenantRequestAdapter()
        viewModel._navigationLiveData.observe { navigation ->
            when (navigation) {
                is TenantNavigation.Request -> {
                    // you can do navigate to whatever fragment you want here
                    Toast.makeText(context, "replace this toast message with navigation to ${navigation.requestId}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
