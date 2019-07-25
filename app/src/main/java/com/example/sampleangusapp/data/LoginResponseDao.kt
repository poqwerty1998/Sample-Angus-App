/*
package com.example.sampleangusapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sampleangusapp.data.entity.LoginDetails
import com.example.sampleangusapp.data.entity.LoginResponse

@Dao
interface LoginResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(loginDetails: LoginDetails)

    @Query("select * from login_details")
    fun getLoginDetail(): LoginDetails

    @Query("delete from login_details")
    fun deleteLoginDetail(username: String)
}*/
