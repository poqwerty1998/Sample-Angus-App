package com.example.sampleangusapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sampleangusapp.data.entity.WorkOrder

@Dao
interface WorkOrderDao {
    @Query("select * from work_order where workOrderId = :equipmentId")
    fun getWorkOrders(equipmentId: Int): LiveData<List<WorkOrder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workOrders: List<WorkOrder>)
}