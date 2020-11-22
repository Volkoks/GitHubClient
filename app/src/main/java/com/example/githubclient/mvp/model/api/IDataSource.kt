package com.example.githubclient.mvp.model.api

import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.mvp.model.entity.ReposGitHubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface IDataSource {
    @GET("/users")
    fun loadUsers(): Single<List<GitHubUser>>

    @GET("/user/{login}")
    fun loadUser(@Path("login") login: String): Single<GitHubUser>

    @GET
    fun getReposUser(@Url url:String):Single<List<ReposGitHubUser>>
}