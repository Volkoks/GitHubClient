package com.example.githubclient.mvp.model.cache

import com.example.githubclient.mvp.model.retrofit.entity.ReposGitHubUser
import io.reactivex.rxjava3.core.Single

interface IReposUserCache {
    fun addReposUser(listRepos:List<ReposGitHubUser>):Single<List<ReposGitHubUser>>
    fun getReposUser():Single<List<ReposGitHubUser>>
}