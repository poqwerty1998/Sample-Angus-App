package com.example.samplelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.samplelogin.mainmenu.MainMenuActivity

const val LOGIN_USERNAME = "admin"
const val LOGIN_PASSWORD = "admin"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val mainMenuIntent = Intent(this, MainMenuActivity::class.java)
        if (username.text.toString() == LOGIN_USERNAME && password.text.toString() == LOGIN_PASSWORD) {
            Toast.makeText(this, "Login success!.", Toast.LENGTH_SHORT).show()
            startActivity(mainMenuIntent)
        } else {
            Toast.makeText(this, "Username or password is incorrect.", Toast.LENGTH_SHORT).show()
        }

    }
}
