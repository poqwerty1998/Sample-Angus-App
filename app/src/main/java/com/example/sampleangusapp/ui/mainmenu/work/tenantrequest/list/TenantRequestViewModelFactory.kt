package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleangusapp.data.repository.AppRepository

class TenantRequestViewModelFactory(
    private val appRepository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TenantRequestViewModel(appRepository) as T
    }
}