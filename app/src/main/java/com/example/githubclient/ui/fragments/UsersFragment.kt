package com.example.githubclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclient.GitHubApp
import com.example.githubclient.R
import com.example.githubclient.mvp.model.repository.GitHubUsersRepo
import com.example.githubclient.mvp.presenter.UsersPresenter
import com.example.githubclient.mvp.view.UserView
import com.example.githubclient.ui.BackButtonListener
import com.example.githubclient.ui.adapter.UserRVAdapter
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UserView, BackButtonListener {


    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GitHubUsersRepo(),
            GitHubApp.instance.router
        )
    }
    var adapter: UserRVAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_users, null)


    override fun init() {
        users_recycler_view.layoutManager =
            LinearLayoutManager(context)
        adapter = UserRVAdapter(presenter.usersListPresenter)
        users_recycler_view.adapter = adapter

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean = presenter.backPressed()


}