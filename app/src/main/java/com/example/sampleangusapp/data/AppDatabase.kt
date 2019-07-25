package com.example.sampleangusapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
<<<<<<< HEAD
import com.example.sampleangusapp.data.entity.WorkOrder

@Database(
    entities = [WorkOrder::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    /*abstract fun loginDetailsDao(): LoginDetailsDao*/
    abstract fun workOrderDao(): WorkOrderDao

=======
import com.example.sampleangusapp.data.entity.LoginResponse
import com.example.sampleangusapp.data.entity.WorkOrder

@Database(
    entities = [LoginResponse::class, WorkOrder::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loginResponseDao(): LoginResponseDao
    abstract fun workOrderDao(): WorkOrderDao
>>>>>>> 68666f1a56caa5296fa424042cbab179da300583
    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

<<<<<<< HEAD
        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
=======
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
>>>>>>> 68666f1a56caa5296fa424042cbab179da300583
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
<<<<<<< HEAD
                    AppDatabase::class.java, "app.db")
=======
                    AppDatabase::class.java, "appDatabaseEntries.db")
>>>>>>> 68666f1a56caa5296fa424042cbab179da300583
                    .build()
    }
}