package com.example.githubclient.navigator

import androidx.fragment.app.Fragment
import com.example.githubclient.ui.fragments.UserFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens {
    class UsersScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return UserFragment.getInstance(0)
        }
    }
}