package com.example.sampleangusapp.data.entity

import androidx.room.Entity

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