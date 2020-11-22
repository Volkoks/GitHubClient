package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.api.IDataSource
import com.example.githubclient.mvp.model.entity.ReposGitHubUser
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGitHubUsersRepo(val api: IDataSource) : IGitHubUsersRepo {
    override fun getUsers() = api.loadUsers().subscribeOn(Schedulers.io())
    override fun getReposUser(url:String)= api.getReposUser(url).subscribeOn(Schedulers.io())
}
