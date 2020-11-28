package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.retrofit.api.IDataSource
import com.example.githubclient.network.INetworkStatus
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitReposUserRepo(val api:IDataSource):IReposUserRepo {
    override fun getReposUser(url: String)= api.getReposUser(url).subscribeOn(Schedulers.io())
}