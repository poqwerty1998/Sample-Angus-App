package com.example.sampleangusapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_LOGIN_ID = 0

@Entity(tableName = "login_details")
data class LoginDetails(

    var username: String,
    var password: String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_LOGIN_ID
}
