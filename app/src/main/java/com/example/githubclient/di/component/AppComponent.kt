package com.example.githubclient.di.component

import com.example.githubclient.di.module.*
import com.example.githubclient.mvp.presenter.MainPresenter
import com.example.githubclient.mvp.presenter.ReposUserPresenter
import com.example.githubclient.mvp.presenter.UserPresenter
import com.example.githubclient.mvp.presenter.UsersPresenter
import com.example.githubclient.ui.activity.MainActivity
import com.example.githubclient.ui.fragments.ReposFragment
import com.example.githubclient.ui.fragments.UserFragment
import com.example.githubclient.ui.fragments.UsersFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CacheModule::class,
        CiceroneModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(userPresenter: UserPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(reposUserPresenter: ReposUserPresenter)
}