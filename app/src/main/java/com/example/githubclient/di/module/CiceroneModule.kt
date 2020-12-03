package com.example.githubclient.di.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class CiceroneModule {
    private var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun getCicerone(): Cicerone<Router> = cicerone

    @Singleton
    @Provides
    fun getNavigatorHolder(): NavigatorHolder = cicerone.navigatorHolder

    @Singleton
    @Provides
    fun getRouter(): Router = cicerone.router
}