package com.example.githubclient.navigator

import androidx.fragment.app.Fragment
import com.example.githubclient.ui.fragments.UserFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen : SupportAppScreen() {
        override fun getFragment() = UserFragment.newInstance()
    }
}
