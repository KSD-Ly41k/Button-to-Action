package com.example.buttontoaction

import android.app.Application
import com.example.buttontoaction.di.DaggerAppComponent

class ButtonApp : Application() {
    private val appComponent = DaggerAppComponent.create()
}
