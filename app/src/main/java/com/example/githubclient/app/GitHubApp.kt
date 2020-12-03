package com.example.githubclient.app

import android.app.Application
import com.example.githubclient.di.component.AppComponent
import com.example.githubclient.di.component.DaggerAppComponent
import com.example.githubclient.di.module.AppModule
import com.example.githubclient.mvp.model.room.database.GitHubDatabase
import dagger.Component
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class GitHubApp : Application() {

    companion object {
        lateinit var instance: GitHubApp
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}