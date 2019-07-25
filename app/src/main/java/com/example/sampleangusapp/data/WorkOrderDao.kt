package com.example.sampleangusapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sampleangusapp.data.entity.WorkOrder

@Dao
interface WorkOrderDao {
<<<<<<< HEAD
    @Query("select * from work_order where workOrderId = :equipmentId")
    fun getWorkOrders(equipmentId: Int): LiveData<List<WorkOrder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workOrders: List<WorkOrder>)
=======
    @Query("select * from work_order")
    fun getWorkOrders(): List<WorkOrder>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(workOrder: WorkOrder)
>>>>>>> 68666f1a56caa5296fa424042cbab179da300583
}