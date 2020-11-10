package com.example.githubclient.mvp.presenter

import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.mvp.view.UserView
import moxy.MvpPresenter

class UserPresenter(val user:GitHubUser?): MvpPresenter<UserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

}