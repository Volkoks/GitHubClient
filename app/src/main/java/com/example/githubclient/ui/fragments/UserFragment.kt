package com.example.githubclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubclient.GitHubApp
import com.example.githubclient.R
import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.mvp.presenter.UserPresenter
import com.example.githubclient.mvp.view.UserView
import com.example.githubclient.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(), UserView,BackButtonListener{

    companion object {
        fun newInstance(user: GitHubUser): MvpAppCompatFragment {
            val fragment = UserFragment()
            val bundle = Bundle()
            bundle.putParcelable("user", user)
            fragment.arguments = bundle
            return fragment
        }
    }

    val presenter by moxyPresenter { UserPresenter(GitHubApp.instance.router) }
    private var user: GitHubUser? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = View.inflate(context, R.layout.fragment_user, null)
        user = arguments?.getParcelable("user")
        return view
    }

    override fun init() {
      activity?.title = user?.login
    }


    override fun backPressed():Boolean = presenter.backPressed()
}
