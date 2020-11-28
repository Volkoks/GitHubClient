package com.example.githubclient.navigator

import com.example.githubclient.mvp.model.retrofit.entity.GitHubUser
import com.example.githubclient.mvp.model.retrofit.entity.ReposGitHubUser
import com.example.githubclient.ui.fragments.ReposFragment
import com.example.githubclient.ui.fragments.UserFragment
import com.example.githubclient.ui.fragments.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class UserScreen(val user: GitHubUser) : SupportAppScreen() {
        override fun getFragment() = UserFragment.newInstance(user)
    }

    class ReposScreen(val reposUser: ReposGitHubUser) : SupportAppScreen() {
        override fun getFragment() = ReposFragment.newInstance(reposUser)
    }
}
