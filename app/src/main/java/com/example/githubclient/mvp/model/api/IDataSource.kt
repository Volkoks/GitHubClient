package com.example.githubclient.mvp.model.api

import com.example.githubclient.mvp.model.entity.GitHubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("/users")
    fun loadUsers(): Single<List<GitHubUser>>

    @GET("/user/{login}")
    fun loadUser(@Path("login") login: String): Single<GitHubUser>
}