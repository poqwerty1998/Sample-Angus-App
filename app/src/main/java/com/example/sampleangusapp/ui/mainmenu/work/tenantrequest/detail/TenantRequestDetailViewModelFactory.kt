package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleangusapp.data.repository.AppRepository

class TenantRequestDetailViewModelFactory(
    private val workOrderId: Int,
    private val appRepository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TenantRequestDetailViewModel(workOrderId, appRepository) as T
    }
}