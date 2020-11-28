package com.example.githubclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubclient.R
import com.example.githubclient.app.GitHubApp
import com.example.githubclient.mvp.model.REPOS_USER
import com.example.githubclient.mvp.model.retrofit.entity.ReposGitHubUser
import com.example.githubclient.mvp.presenter.ReposUserPresenter
import com.example.githubclient.mvp.view.ReposUserView
import com.example.githubclient.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_repos.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class ReposFragment : MvpAppCompatFragment(), ReposUserView, BackButtonListener {
    companion object {
        fun newInstance(repos: ReposGitHubUser): ReposFragment {
            val fragment = ReposFragment()
            val bundle = Bundle()
            bundle.putParcelable(REPOS_USER, repos)
            fragment.arguments = bundle
            return fragment
        }
    }

    val presenter by moxyPresenter {
        ReposUserPresenter(GitHubApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_repos, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
presenter.repos = arguments?.getParcelable(REPOS_USER)
    }


    override fun backPressed() = presenter.backPressed()
    override fun init(reposGitHubUser: ReposGitHubUser) {
        fork_repos_tv.text = reposGitHubUser.forks.toString()
        description_repos_tv.text = reposGitHubUser.description
    }

}