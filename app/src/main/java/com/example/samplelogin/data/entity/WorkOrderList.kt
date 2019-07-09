package com.example.samplelogin.data.entity

import com.google.gson.annotations.SerializedName

data class WorkOrderList(
    @SerializedName("WorkOrders")
    var workOrders: List<WorkOrder>
)