package com.example.samplelogin.ui.mainmenu.overview

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.samplelogin.R
import kotlinx.android.synthetic.main.activity_overview.*

class OverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)
        setSupportActionBar(toolbar)

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home ->  {
                finish()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}