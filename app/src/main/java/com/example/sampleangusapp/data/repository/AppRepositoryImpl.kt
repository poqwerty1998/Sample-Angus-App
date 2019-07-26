package com.example.sampleangusapp.data.repository

import androidx.lifecycle.LiveData
import com.example.sampleangusapp.data.WorkOrderDao
import com.example.sampleangusapp.data.entity.LoginDetails
import com.example.sampleangusapp.data.entity.WorkOrder
import com.example.sampleangusapp.data.network.AppNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

class AppRepositoryImpl(
    private val workOrderDao: WorkOrderDao,
    private val appNetworkDataSource: AppNetworkDataSource
) : AppRepository {

    init {
        appNetworkDataSource.apply {
            downloadedWorkOrders.observeForever { newWorkOrders ->
                persistFetchedWorkOrders(newWorkOrders)
            }
        }
    }

    override suspend fun getWorkOrders(equipmentId: Int): LiveData<List<WorkOrder>> {
        return withContext(Dispatchers.IO) {
            initAppData()
            return@withContext workOrderDao.getWorkOrders()
        }
    }

    private fun persistLoginDetails(loginDetails: LoginDetails) {

    }

    private fun persistFetchedWorkOrders(fetchedWorkOrder: List<WorkOrder>) {
        fun deleteOldData() {
            val today = LocalDate.now()
            workOrderDao.deleteOldEntries(today)
        }

        GlobalScope.launch(Dispatchers.IO) {
            deleteOldData()
            workOrderDao.insert(fetchedWorkOrder)
        }
    }

    private suspend fun initAppData() {
        if(isFetchWONeeded(ZonedDateTime.now().minusHours(1)))
            fetchedWorkOrder()
    }

    private suspend fun fetchedWorkOrder() {
        appNetworkDataSource.fetchWorkOrders(1100000005)
    }

    private fun isFetchWONeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }
}
