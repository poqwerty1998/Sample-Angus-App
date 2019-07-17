package com.example.sampleangusapp.data.entity


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Task(
    @SerializedName("Description")
    val description: String,
    @SerializedName("MinutesEstimated")
    val minutesEstimated: Int
)