package com.example.samplelogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.samplelogin.R
import com.example.samplelogin.data.LoginValidate
import com.example.samplelogin.data.RetrofitClientInstance
import com.example.samplelogin.data.UserDetails
import com.example.samplelogin.ui.mainmenu.MainMenuActivity
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
        /*if (username.text.toString() == LOGIN_USERNAME && password.text.toString() == LOGIN_PASSWORD) {
            Toast.makeText(this, "Login success!.", Toast.LENGTH_SHORT).show()
            val mainMenuIntent = Intent(this, MainMenuActivity::class.java)
            startActivity(mainMenuIntent)
        } else {
            Toast.makeText(this, "Username or password is incorrect.", Toast.LENGTH_SHORT).show()
        }*/

        RetrofitClientInstance.retrofitInstance.validate(
            username,
            password
        ).enqueue(object: Callback<UserDetails>{
            override fun onFailure(call: Call<UserDetails>, t: Throwable) {
                Toast.makeText(applicationContext, "$username $password", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                //Toast.makeText(applicationContext, "Login success!", Toast.LENGTH_LONG).show()
                if(response.isSuccessful) {
                    val mainMenuIntent = Intent(applicationContext, MainMenuActivity::class.java)
                    startActivity(mainMenuIntent)
                } else {
                    when(response.code()) {
                        302 -> {
                            val mainMenuIntent = Intent(applicationContext, MainMenuActivity::class.java)
                            startActivity(mainMenuIntent)
                        }
                        else -> {
                            Toast.makeText(applicationContext, "Username or password is incorrect.", Toast.LENGTH_LONG).show()
                        }
                    }
                }

            }
        })

    }
}
