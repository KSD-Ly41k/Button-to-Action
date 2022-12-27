package com.example.buttontoaction.di

import android.app.Application

class ButtonApp : Application() {
    private val appComponent = DaggerAppComponent.create()
}
