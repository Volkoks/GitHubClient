package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.entity.GitHubUser

object GitHubRepo {
    var repository:List<GitHubUser> = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5"),
        GitHubUser("login6"),
        GitHubUser("login7"),
        GitHubUser("login8"),
    )
}