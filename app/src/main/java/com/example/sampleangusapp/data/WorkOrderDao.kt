package com.example.sampleangusapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sampleangusapp.data.entity.WorkOrder
import org.threeten.bp.LocalDate

@Dao
interface WorkOrderDao {
    @Query("select * from work_order")
    fun getWorkOrders(): LiveData<List<WorkOrder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workOrders: List<WorkOrder>)

    @Query("delete from work_order where date(dispatchDate) < date(:date)")
    fun deleteOldEntries(date: LocalDate)
}