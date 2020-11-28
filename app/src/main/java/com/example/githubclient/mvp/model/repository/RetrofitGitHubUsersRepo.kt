package com.example.githubclient.mvp.model.repository

import com.example.githubclient.mvp.model.retrofit.api.IDataSource
import com.example.githubclient.mvp.model.retrofit.entity.GitHubUser
import com.example.githubclient.mvp.model.room.database.GitHubDatabase
import com.example.githubclient.mvp.model.room.entity.RoomUser
import com.example.githubclient.network.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGitHubUsersRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val db: GitHubDatabase
) : IGitHubUsersRepo {
    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.loadUsers().flatMap { users ->
                Single.fromCallable {
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

            }
        } else {
            Single.fromCallable {
                db.userDao.getAllUsers().map { roomUser ->
                    GitHubUser(roomUser.id, roomUser.login, roomUser.avatarUrl, roomUser.reposUrl)
                }
            }
        }
    }.subscribeOn(Schedulers.io())
}
