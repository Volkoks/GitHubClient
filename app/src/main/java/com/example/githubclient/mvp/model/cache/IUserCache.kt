package com.example.githubclient.mvp.model.cache

import com.example.githubclient.mvp.model.retrofit.entity.GitHubUser
import io.reactivex.rxjava3.core.Single

interface IUserCache {
    fun addUsers(users:List<GitHubUser>): Single<List<GitHubUser>>
    fun getUsers():Single<List<GitHubUser>>
}