package com.example.sampleangusapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sampleangusapp.data.entity.CURRENT_LOGIN_ID

/*
@Dao
interface LoginDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(loginDetails: LoginDetails)

    @Query("select * from login_details where id = $CURRENT_LOGIN_ID")
    fun getLoginDetails(): LiveData<LoginDetails>
}*/
