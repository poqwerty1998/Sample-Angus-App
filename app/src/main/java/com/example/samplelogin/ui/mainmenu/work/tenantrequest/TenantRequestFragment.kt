package com.example.samplelogin.ui.mainmenu.work.tenantrequest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.samplelogin.R
import com.example.samplelogin.ui.base.ScopedFragment
import com.example.samplelogin.ui.mainmenu.MainMenuActivity
import com.example.samplelogin.ui.mainmenu.work.MyWorkActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.tenant_request_fragment.*
import kotlinx.coroutines.Dispatchers
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class TenantRequestFragment : Fragment() {

    //override val kodein by closestKodein()
    private lateinit var viewModel: TenantRequestViewModel

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
    }

}
