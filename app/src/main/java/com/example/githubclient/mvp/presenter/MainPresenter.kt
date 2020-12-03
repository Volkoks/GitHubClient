package com.example.githubclient.mvp.presenter


import com.example.githubclient.mvp.view.MainView
import com.example.githubclient.navigator.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class MainPresenter() : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen())
    }
}