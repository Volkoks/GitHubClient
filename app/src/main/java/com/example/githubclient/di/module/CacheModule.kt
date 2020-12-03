package com.example.githubclient.di.module


import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.githubclient.app.GitHubApp
import com.example.githubclient.mvp.model.cache.IReposUserCache
import com.example.githubclient.mvp.model.cache.IUserCache
import com.example.githubclient.mvp.model.cache.room.RoomReposUserCache
import com.example.githubclient.mvp.model.cache.room.RoomUsersCache
import com.example.githubclient.mvp.model.room.database.GitHubDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app:GitHubApp):GitHubDatabase = Room.databaseBuilder(
        app,GitHubDatabase::class.java,GitHubDatabase.DB_NAME).build()

    @Singleton
    @Provides
    fun usersCache(database: GitHubDatabase):IUserCache = RoomUsersCache(database)

    @Singleton
    @Provides
    fun reposUserCache(database: GitHubDatabase):IReposUserCache = RoomReposUserCache(database)
}