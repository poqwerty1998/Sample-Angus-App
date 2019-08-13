package com.example.sampleangusapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleangusapp.R
import com.example.sampleangusapp.data.AppDatabase
import com.example.sampleangusapp.data.entity.LoginDetails
import com.example.sampleangusapp.data.entity.LoginResponse
import com.example.sampleangusapp.data.network.AngusApiService
import com.example.sampleangusapp.data.network.RetrofitClientInstance
import com.example.sampleangusapp.data.repository.AppRepository
import com.example.sampleangusapp.internal.lazyDeferred
import com.example.sampleangusapp.ui.mainmenu.MainMenuActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        // clear login fields if user logs out from the app
        username.text.clear()
        password.text.clear()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.loginButton -> {
                login(view)
            }
        }
    }

    private fun login(view: View) {
        val username = findViewById<EditText>(R.id.username).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        AngusApiService.setCredentials(username, password)
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username or password is empty.", Toast.LENGTH_LONG).show()
        } else {
            // put the entered details in the local db
            /*LoginDetails.setDetails(username, password)*/
            RetrofitClientInstance.retrofitInstance.validateLogin(
                username,
                password
            ).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        if(responseBodyHasError(loginResponse)) {
                            /*val db = AppDatabase.invoke(applicationContext)
                            db.loginResponseDao().upsert(LoginDetails())*/
                            Toast.makeText(applicationContext,
                                "Username or password is incorrect.", Toast.LENGTH_LONG).show()
                        } else {
                            val mainMenuIntent = Intent(applicationContext, MainMenuActivity::class.java)
                            // put the fields through so the next activity can retrieve it
                            mainMenuIntent.putExtra("loginResponse", loginResponse)
                            mainMenuIntent.putExtra("username", username)
                            mainMenuIntent.putExtra("password", password)
                            RetrofitClientInstance.setCredentials(username, password)

                            startActivity(mainMenuIntent)
                            Toast.makeText(applicationContext, "Login success!", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(applicationContext,
                            "Something wrong with the server. Please try again later.", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext,
                        "Something wrong with the server. Please try again later.", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    fun responseBodyHasError(responseBody: LoginResponse?): Boolean {
        return responseBody?.userName == null
    }
}
