package com.example.sampleangusapp.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sampleangusapp.data.entity.WorkOrder
import com.example.sampleangusapp.internal.NoConnectivityException

class AppNetworkDataSourceImpl(
    private val angusApiService: AngusApiService
) : AppNetworkDataSource {

    private val _downloadedWorkOrders = MutableLiveData<List<WorkOrder>>()
    override val downloadedWorkOrders: LiveData<List<WorkOrder>>
        get() = _downloadedWorkOrders

    override suspend fun fetchWorkOrders(equipmentId: Int) {
        try {
            val fetchedWorkOrders = angusApiService
                .getWorkOrders(equipmentId)
                .await()
            _downloadedWorkOrders.postValue(fetchedWorkOrders)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }
}