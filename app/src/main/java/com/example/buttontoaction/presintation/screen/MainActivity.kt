package com.example.buttontoaction.presintation.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buttontoaction.R
import com.example.buttontoaction.di.ButtonApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
     lateinit var    viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButtonApp.appComponent.inject(this)
        setContentView(R.layout.activity_main)
    }
}