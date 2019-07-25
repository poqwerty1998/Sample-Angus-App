package com.example.sampleangusapp.data.network

import androidx.lifecycle.LiveData
import com.example.sampleangusapp.data.entity.WorkOrder

interface AppNetworkDataSource {
    val downloadedWorkOrders: LiveData<List<WorkOrder>>

    suspend fun fetchWorkOrders(
        equipmentId: Int
    )
}