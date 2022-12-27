package com.example.buttontoaction.di

import android.app.Application

class ButtonApp : Application() {
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }


}
