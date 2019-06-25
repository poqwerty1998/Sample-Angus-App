package com.example.samplelogin.ui.mainmenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.samplelogin.R
import com.example.samplelogin.ui.mainmenu.create.CreateActivity
import com.example.samplelogin.ui.mainmenu.overview.OverviewActivity
import com.example.samplelogin.ui.mainmenu.search.SearchActivity
import com.example.samplelogin.ui.mainmenu.work.MyWorkActivity

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }


    fun myWork(view: View) {
        val myWorkIntent = Intent(this, MyWorkActivity::class.java)
        startActivity(myWorkIntent)
    }

    fun overview(view: View) {
        val overviewIntent = Intent(this, OverviewActivity::class.java)
        startActivity(overviewIntent)
    }

    fun create(view: View) {
        val createIntent = Intent(this, CreateActivity::class.java)
        startActivity(createIntent)
    }

    fun search(view: View) {
        val searchIntent = Intent(this, SearchActivity::class.java)
        startActivity(searchIntent)
    }
}