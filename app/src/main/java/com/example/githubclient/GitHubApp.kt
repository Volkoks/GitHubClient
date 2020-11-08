package com.example.githubclient

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class GitHubApp : Application() {

    companion object {
        private lateinit var cicerone: Cicerone<Router>

        fun getRouter(): Router {
            return cicerone.router
        }
        fun navigateHolder(): NavigatorHolder {
            return cicerone.navigatorHolder
        }
    }

    override fun onCreate() {
        super.onCreate()
        initCicerone()
    }

    private fun initCicerone() {
        cicerone = Cicerone.create()
    }
}