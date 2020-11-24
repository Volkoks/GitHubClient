package com.example.githubclient.mvp.view

import com.example.githubclient.mvp.model.entity.ReposGitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ReposUserView : MvpView {
    fun init(reposGitHubUser: ReposGitHubUser)
}