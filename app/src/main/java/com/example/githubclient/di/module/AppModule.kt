package com.example.githubclient.di.module

import com.example.githubclient.app.GitHubApp
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

@Module
class AppModule(val app:GitHubApp) {

    @Provides
    fun app():GitHubApp{
        return app
    }
    @Provides
    fun mainTreadScheduler():Scheduler{
        return AndroidSchedulers.mainThread()
    }
}