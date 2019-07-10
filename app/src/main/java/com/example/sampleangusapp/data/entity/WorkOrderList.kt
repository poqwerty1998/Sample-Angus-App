package com.example.sampleangusapp.data.entity

import com.google.gson.annotations.SerializedName

data class WorkOrderList(
    @SerializedName("WorkOrders")
    var workOrders: List<WorkOrder>
)