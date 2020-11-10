package com.example.githubclient.mvp.presenter

import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.mvp.view.UserView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UserPresenter(val router: Router): MvpPresenter<UserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}