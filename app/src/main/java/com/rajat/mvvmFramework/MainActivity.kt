package com.rajat.mvvmFramework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rajat.mvvmFramework.ui.list.ListFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .add(R.id.screenContainer, ListFragment()).commit()
    }
}