package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail

import com.example.sampleangusapp.data.repository.AppRepository
import com.example.sampleangusapp.internal.lazyDeferred
import com.example.sampleangusapp.ui.base.AppViewModel

class TenantRequestDetailViewModel(
    private val workOrderId: Int,
    private val appRepository: AppRepository
) : AppViewModel(appRepository) {

    val workOrder by lazyDeferred {
        appRepository.getWorkOrder(workOrderId)
    }
}
