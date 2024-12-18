package com.example.nytimesapp

import android.app.Application
import com.example.nytimesapp.di.ApplicationComponent
import com.example.nytimesapp.di.DaggerApplicationComponent
import com.google.gson.Gson

class NewsApp : Application() {

    val gson = Gson()

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this, gson)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}
