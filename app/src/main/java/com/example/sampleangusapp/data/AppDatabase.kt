package com.example.sampleangusapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sampleangusapp.data.entity.LoginResponse
import com.example.sampleangusapp.data.entity.WorkOrder

@Database(
    entities = [LoginResponse::class, WorkOrder::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loginResponseDao(): LoginResponseDao
    abstract fun workOrderDao(): WorkOrderDao
}