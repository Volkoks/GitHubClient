package com.example.githubclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclient.app.GitHubApp
import com.example.githubclient.R
import com.example.githubclient.mvp.model.retrofit.api.ApiHolder
import com.example.githubclient.mvp.model.retrofit.entity.GitHubUser
import com.example.githubclient.mvp.model.repository.RetrofitGitHubUsersRepo
import com.example.githubclient.mvp.model.repository.RetrofitReposUserRepo
import com.example.githubclient.mvp.presenter.UserPresenter
import com.example.githubclient.mvp.view.UserView
import com.example.githubclient.network.AndroidNetworkStatus
import com.example.githubclient.ui.BackButtonListener
import com.example.githubclient.ui.adapter.ReposUserAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {
        fun newInstance(user: GitHubUser): MvpAppCompatFragment {
            val fragment = UserFragment()
            val bundle = Bundle()
            bundle.putParcelable("user", user)
            fragment.arguments = bundle
            return fragment
        }
    }

    val presenter by moxyPresenter {
        UserPresenter(
            AndroidSchedulers.mainThread(),
            RetrofitReposUserRepo(ApiHolder.api),
            GitHubApp.instance.router
        )
    }
    private var user: GitHubUser? = null
    private var adapter: ReposUserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = View.inflate(context, R.layout.fragment_user, null)
        presenter.user = arguments?.getParcelable("user")
        user = arguments?.getParcelable("user")
        return view
    }

    override fun init() {
        activity?.title = user?.login
        repos_user_rv.layoutManager = LinearLayoutManager(context)
        adapter = ReposUserAdapter(presenter.reposUserPresenter)
        repos_user_rv.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(context, "Ошибка: ${error.message}", Toast.LENGTH_SHORT).show()
    }


    override fun backPressed(): Boolean = presenter.backPressed()
}
