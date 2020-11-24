package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.mvp.model.entity.ReposGitHubUser
import io.reactivex.rxjava3.core.Single

interface IGitHubUsersRepo {
    fun getUsers(): Single<List<GitHubUser>>
    fun getReposUser(url:String): Single<List<ReposGitHubUser>>
}