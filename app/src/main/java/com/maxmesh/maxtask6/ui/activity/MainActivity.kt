package com.maxmesh.maxtask6.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maxmesh.maxtask6.R
import com.maxmesh.maxtask6.ui.fragments.ListContactsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ListContactsFragment())
            .commit()
    }
}