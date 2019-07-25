package com.example.sampleangusapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sampleangusapp.data.entity.WorkOrder

@Database(
    entities = [WorkOrder::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    /*abstract fun loginDetailsDao(): LoginDetailsDao*/
    abstract fun workOrderDao(): WorkOrderDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "app.db")
                    .build()
    }
}