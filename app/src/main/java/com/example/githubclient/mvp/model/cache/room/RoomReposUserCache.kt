package com.example.githubclient.mvp.model.cache.room

import com.example.githubclient.mvp.model.cache.IReposUserCache
import com.example.githubclient.mvp.model.retrofit.entity.ReposGitHubUser
import com.example.githubclient.mvp.model.room.database.GitHubDatabase
import com.example.githubclient.mvp.model.room.entity.RoomReposUser
import io.reactivex.rxjava3.core.Single

class RoomReposUserCache(val db: GitHubDatabase) : IReposUserCache {
    override fun addReposUser(listRepos: List<ReposGitHubUser>) = Single.fromCallable {
        val reposUser = listRepos.map { repo ->
            RoomReposUser(
                repo.id ?: "",
                repo.name ?: "",
                repo.forks ?: 0,
                repo.description ?: ""
            )
        }
        db.reposUserDao.insert(reposUser)
        listRepos
    }

    override fun getReposUser() = Single.fromCallable {
        db.reposUserDao.getAllUsers().map { roomRepos ->
            ReposGitHubUser(
                roomRepos.id,
                roomRepos.name,
                roomRepos.forks,
                roomRepos.description
            )
        }
    }
}