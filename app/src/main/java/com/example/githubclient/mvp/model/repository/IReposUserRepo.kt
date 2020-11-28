package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.retrofit.entity.ReposGitHubUser
import io.reactivex.rxjava3.core.Single

interface IReposUserRepo {
    fun getReposUser(url:String): Single<List<ReposGitHubUser>>
}