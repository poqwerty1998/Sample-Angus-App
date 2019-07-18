package com.example.sampleangusapp.data.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "work_order")
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
    @Embedded(prefix = "task_")
    val tasks: List<Task>,
    @SerializedName("WorkOrderStatus")
    val workOrderStatus: Int,
    @SerializedName("WorkOrderTitle")
    val workOrderTitle: String,
    @SerializedName("WorkOrderType")
    val workOrderType: Int
)