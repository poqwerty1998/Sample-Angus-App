package com.example.sampleangusapp.data.entity

import androidx.room.Entity
<<<<<<< HEAD
import androidx.room.PrimaryKey

const val CURRENT_LOGIN_ID = 0

/*
@Entity(tableName = "login_details")
data class LoginDetails(
    private var username: String,
    private var password: String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_LOGIN_ID

    fun setUsername(username: String) {
        this.username = username
    }

    fun setPassword(password: String) {
        this.password = password
    }
}*/
=======

@Entity(tableName = "login_details")
class LoginDetails(
) {
    companion object {
        private var username: String = ""
        private var password: String = ""
        fun setDetails(username: String, password: String) {
            this.username = username
            this.password = password
        }
    }
}
>>>>>>> 68666f1a56caa5296fa424042cbab179da300583
