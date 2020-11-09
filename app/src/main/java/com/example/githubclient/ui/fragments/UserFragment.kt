package com.example.githubclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclient.GitHubApp
import com.example.githubclient.R
import com.example.githubclient.mvp.model.repository.GitHubUsersRepo
import com.example.githubclient.mvp.presenter.UsersPresenter
import com.example.githubclient.mvp.view.UserView
import com.example.githubclient.ui.adapter.UserRVAdapter
import kotlinx.android.synthetic.main.fragment_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(), UserView {


    companion object {
        fun newInstance() = UserFragment()
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
    )= View.inflate(context,R.layout.fragment_user,null)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       }

    override fun init() {
        user_recycler_view.setHasFixedSize(true)
        user_recycler_view.layoutManager =
            LinearLayoutManager(context)
        adapter = UserRVAdapter(presenter.usersListPresenter)
        user_recycler_view.adapter = adapter

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }


}