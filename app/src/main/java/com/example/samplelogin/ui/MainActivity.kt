package com.example.samplelogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.samplelogin.R
import com.example.samplelogin.data.LoginResponse
import com.example.samplelogin.data.RetrofitClientInstance
import com.example.samplelogin.ui.mainmenu.MainMenuActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val LOGIN_USERNAME = "admin"
const val LOGIN_PASSWORD = "admin"

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {
        val username = findViewById<EditText>(R.id.username).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        RetrofitClientInstance.retrofitInstance.validate(
            "",
            username,
            password,
            "Postman",
            "2.23.0.48"
        ).enqueue(object: Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                //Toast.makeText(applicationContext, "Login success!", Toast.LENGTH_LONG).show()
                if(response.isSuccessful) {
                    val loginResponse = response.body()
                    val mainMenuIntent = Intent(applicationContext, MainMenuActivity::class.java)
                    mainMenuIntent.putExtra("loginResponse", loginResponse)
                    startActivity(mainMenuIntent)
                    Toast.makeText(applicationContext, "Login success!", Toast.LENGTH_LONG).show()
                } else {
                    /*when(response.code()) {
                        302 -> {
                            val mainMenuIntent = Intent(applicationContext, MainMenuActivity::class.java)
                            startActivity(mainMenuIntent)
                        }
                        else -> {
                            Toast.makeText(applicationContext, "Username or password is incorrect.", Toast.LENGTH_LONG).show()
                        }
                    }*/
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Username or password is incorrect.", Toast.LENGTH_LONG).show()
            }

        })

    }
}
