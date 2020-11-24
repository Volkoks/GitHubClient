package com.example.githubclient.app

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class GitHubApp : Application() {

    companion object {
        lateinit var instance: GitHubApp
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val router
        get() = cicerone.router
    val navigatorHolder
        get() = cicerone.navigatorHolder

}