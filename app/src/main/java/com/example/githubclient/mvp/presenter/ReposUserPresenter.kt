package com.example.githubclient.mvp.presenter

import com.example.githubclient.mvp.model.retrofit.entity.ReposGitHubUser
import com.example.githubclient.mvp.view.ReposUserView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ReposUserPresenter() : MvpPresenter<ReposUserView>() {

    @Inject
    lateinit var router: Router

    var repos: ReposGitHubUser? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repos?.let { viewState.init(it) }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}