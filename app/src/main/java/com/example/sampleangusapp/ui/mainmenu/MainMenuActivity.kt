package com.example.sampleangusapp.ui.mainmenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleangusapp.R
import com.example.sampleangusapp.data.entity.LoginResponse
import com.example.sampleangusapp.data.network.RetrofitClientInstance
import com.example.sampleangusapp.ui.MainActivity
import com.example.sampleangusapp.ui.mainmenu.create.CreateActivity
import com.example.sampleangusapp.ui.mainmenu.overview.OverviewActivity
import com.example.sampleangusapp.ui.mainmenu.search.SearchActivity
import com.example.sampleangusapp.ui.mainmenu.work.MyWorkActivity
import kotlinx.android.synthetic.main.activity_main_menu.*

const val BACK_STACK_ROOT_TAG = "root_fragment"

class MainMenuActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // after log in, retrieve the login response that was previously serialized
        val intent = intent
        val loginResponse = intent.getSerializableExtra("loginResponse") as LoginResponse
        val username = intent.getSerializableExtra("username") as String
        val password = intent.getSerializableExtra("password") as String
        RetrofitClientInstance.setCredentials("angusdemo\\$username", password)
        employeeName.text = loginResponse.realName

    }

    override fun onClick(view: View) {
        val intent: Intent
        when(view.id) {
            R.id.my_work_button -> {
                intent = Intent(this, MyWorkActivity::class.java)
                startActivity(intent)
            }
            R.id.overview_button -> {
                intent = Intent(this, OverviewActivity::class.java)
                startActivity(intent)
            }
            R.id.create_button -> {
                intent = Intent(this, CreateActivity::class.java)
                startActivity(intent)
            }
            R.id.search_button -> {
                intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun logOut(view: View) {
        val logoutIntent = Intent(this, MainActivity::class.java)
        startActivity(logoutIntent)
        this.finish()
    }
}