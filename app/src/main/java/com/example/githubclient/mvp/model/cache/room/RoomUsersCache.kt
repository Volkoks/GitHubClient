package com.example.githubclient.mvp.model.cache.room

import com.example.githubclient.mvp.model.cache.IUserCache
import com.example.githubclient.mvp.model.retrofit.entity.GitHubUser
import com.example.githubclient.mvp.model.room.database.GitHubDatabase
import com.example.githubclient.mvp.model.room.entity.RoomUser
import io.reactivex.rxjava3.core.Single

class RoomUsersCache(var db: GitHubDatabase) : IUserCache {


    override fun addUsers(users: List<GitHubUser>) = Single.fromCallable {
        val roomUsers = users.map { user ->
            RoomUser(
                user.id ?: "",
                user.login ?: "",
                user.avatarUrl ?: "",
                user.reposUrl ?: ""
            )
        }
        db.userDao.insert(roomUsers)
        users
    }

    override fun getUsers() =   Single.fromCallable {
        db.userDao.getAllUsers().map { roomUser ->
            GitHubUser(roomUser.id, roomUser.login, roomUser.avatarUrl, roomUser.reposUrl)
        }
    }


}