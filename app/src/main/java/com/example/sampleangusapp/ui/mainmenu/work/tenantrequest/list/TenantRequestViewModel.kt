package com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list

import com.example.sampleangusapp.data.repository.AppRepository
import com.example.sampleangusapp.internal.lazyDeferred
import com.example.sampleangusapp.ui.base.AppViewModel

class TenantRequestViewModel(
    private val appRepository: AppRepository
) : AppViewModel(appRepository) {

    val workOrders by lazyDeferred {
        appRepository.getWorkOrders(super.equipmentId)
    }
}