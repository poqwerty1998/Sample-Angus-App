package com.example.sampleangusapp.ui.mainmenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleangusapp.R
import com.example.sampleangusapp.data.entity.LoginResponse
import com.example.sampleangusapp.ui.MainActivity
import com.example.sampleangusapp.ui.mainmenu.create.CreateActivity
import com.example.sampleangusapp.ui.mainmenu.overview.OverviewActivity
import com.example.sampleangusapp.ui.mainmenu.search.SearchActivity
import com.example.sampleangusapp.ui.mainmenu.work.MyWorkActivity
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // after log in, retrieve the login response that was previously serialized
        val intent = intent
        val loginResponse = intent.getSerializableExtra("loginResponse") as LoginResponse
        employeeName.text = loginResponse.realName

    }

    override fun onClick(view: View?) {
        val intent: Intent
        when(view?.id) {
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
            R.id.logoutButton -> {
                logOut(view)
            }
        }
    }

    override fun onBackPressed() {
        confirmExitMessage()
    }

    private fun logOut(view: View) {
        confirmExitMessage()
    }

    private fun confirmExitMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ -> this@MainMenuActivity.finish() }
            .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }
}