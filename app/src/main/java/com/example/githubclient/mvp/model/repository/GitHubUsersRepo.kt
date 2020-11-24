package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.entity.GitHubUser
import io.reactivex.rxjava3.core.Observable

class GitHubUsersRepo {
    private val repository = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5"),
        GitHubUser("login6"),
        GitHubUser("login7"),
        GitHubUser("login8"),
    )

    fun getUser():Observable<List<GitHubUser>>{
        return Observable.fromIterable(listOf(repository))
    }
}