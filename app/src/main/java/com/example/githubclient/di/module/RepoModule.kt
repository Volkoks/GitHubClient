package com.example.githubclient.di.module

import com.example.githubclient.mvp.model.cache.IReposUserCache
import com.example.githubclient.mvp.model.cache.IUserCache
import com.example.githubclient.mvp.model.repository.IGitHubUsersRepo
import com.example.githubclient.mvp.model.repository.IReposUserRepo
import com.example.githubclient.mvp.model.repository.RetrofitGitHubUsersRepo
import com.example.githubclient.mvp.model.repository.RetrofitReposUserRepo
import com.example.githubclient.mvp.model.retrofit.api.IDataSource
import com.example.githubclient.network.INetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun userRepo(
        api: IDataSource, networkStatus: INetworkStatus, cache: IUserCache
    ): IGitHubUsersRepo = RetrofitGitHubUsersRepo(
        api,
        networkStatus,
        cache
    )

    @Singleton
    @Provides
    fun reposUserRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IReposUserCache
    ): IReposUserRepo =
        RetrofitReposUserRepo(
            api,
            networkStatus,
            cache
        )
}