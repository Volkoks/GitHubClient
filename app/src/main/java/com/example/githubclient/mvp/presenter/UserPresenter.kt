package com.example.githubclient.mvp.presenter

import com.example.githubclient.mvp.model.repository.IGitHubUsersRepo
import com.example.githubclient.mvp.view.UserView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UserPresenter(
    val router: Router
) :
    MvpPresenter<UserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}