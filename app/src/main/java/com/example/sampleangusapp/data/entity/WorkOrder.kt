package com.example.sampleangusapp.data.entity


import androidx.room.Embedded
import androidx.room.Entity
<<<<<<< HEAD
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

private const val WORK_ORDER_ID = 1100000005

@Entity(tableName = "work_order", indices = [Index(value = ["displayId"], unique = true)])
=======
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "work_order")
>>>>>>> 68666f1a56caa5296fa424042cbab179da300583
data class WorkOrder(
    @PrimaryKey(autoGenerate = true)
    val workOrderId: Int,
    @SerializedName("AssignedToEmployeeId")
    val assignedToEmployeeId: Int,
    @SerializedName("AssignedToFirstName")
    val assignedToFirstName: String,
    @SerializedName("AssignedToLastName")
    val assignedToLastName: String,
    @SerializedName("ClosedOrCancelledDate")
    val closedOrCancelledDate: String,
    @SerializedName("DispatchDate")
    val dispatchDate: String,
    @SerializedName("DisplayId")
    val displayId: String,
    @SerializedName("Frequency")
    val frequency: Int,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Period")
    val period: Int,
    @SerializedName("Priority")
    val priority: Int,
    @SerializedName("ScheduleDate")
    val scheduleDate: String,
<<<<<<< HEAD
=======
    @Embedded(prefix = "task_")
    val tasks: List<Task>,
>>>>>>> 68666f1a56caa5296fa424042cbab179da300583
    @SerializedName("WorkOrderStatus")
    val workOrderStatus: Int,
    @SerializedName("WorkOrderTitle")
    val workOrderTitle: String,
    @SerializedName("WorkOrderType")
    val workOrderType: Int
) {
    @PrimaryKey(autoGenerate = false)
    var workOrderId: Int = WORK_ORDER_ID
}