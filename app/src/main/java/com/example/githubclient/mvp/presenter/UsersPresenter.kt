package com.example.githubclient.mvp.presenter


import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.mvp.model.repository.GitHubUsersRepo
import com.example.githubclient.mvp.presenter.list.IUserListPresenter
import com.example.githubclient.mvp.view.UserItemView
import com.example.githubclient.mvp.view.UsersView
import com.example.githubclient.navigator.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(val userRepo: GitHubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {

    class UserListPresenter : IUserListPresenter {
        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null


        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size

    }

    val usersListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = {
            val user: GitHubUser = usersListPresenter.users[it.pos]
            router.navigateTo(Screens.UserScreen(user))
        }
    }

    private fun loadData() {
        userRepo.getUser()
            .subscribe({ onNext -> usersListPresenter.users.addAll(onNext) },
                { error -> "Ошибка: ${error}" })
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}