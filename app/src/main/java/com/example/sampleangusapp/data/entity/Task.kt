package com.example.sampleangusapp.data.entity

import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("Description")
    val description: String,
    @SerializedName("MinutesEstimated")
    val minutesEstimated: Int
)