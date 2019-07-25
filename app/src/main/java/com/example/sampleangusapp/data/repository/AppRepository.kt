package com.example.sampleangusapp.data.repository

import androidx.lifecycle.LiveData
import com.example.sampleangusapp.data.entity.WorkOrder

interface AppRepository {

    suspend fun getWorkOrders(equipmentId: Int): LiveData<List<WorkOrder>>
}