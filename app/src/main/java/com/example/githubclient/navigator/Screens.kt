package com.example.githubclient.navigator

import androidx.fragment.app.Fragment
import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.ui.fragments.UserFragment
import com.example.githubclient.ui.fragments.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }
    class UserScreen(): SupportAppScreen(){
        override fun getFragment() = UserFragment.newInstance()
    }
}
