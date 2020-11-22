package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.api.IDataSource
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGitHubUsersRepo(val api: IDataSource) : IGitHubUsersRepo {
    override fun getUsers() = api.loadUsers().subscribeOn(Schedulers.io())
}
