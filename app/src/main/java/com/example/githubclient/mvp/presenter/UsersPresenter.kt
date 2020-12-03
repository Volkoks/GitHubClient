package com.example.githubclient.mvp.presenter


import com.example.githubclient.mvp.model.retrofit.entity.GitHubUser
import com.example.githubclient.mvp.model.repository.IGitHubUsersRepo
import com.example.githubclient.mvp.presenter.list.IUserListPresenter
import com.example.githubclient.mvp.view.UserItemView
import com.example.githubclient.mvp.view.UsersView
import com.example.githubclient.navigator.Screens
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class UsersPresenter() : MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var usersRepo: IGitHubUsersRepo

    @Inject
    lateinit var mainThreadScheduler: Scheduler

    class UserListPresenter : IUserListPresenter {
        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null


        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            user.login?.let { view.setLogin(it) }
            user.avatarUrl?.let { view.loadAvatar(it) }
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
        usersRepo.getUsers()
            .observeOn(mainThreadScheduler)
            .subscribe({ userList ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(userList)
                viewState.updateList()
            },
                { error -> println("Ошибка: ${error}") })

    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}