package com.example.githubclient.mvp.presenter


import com.example.githubclient.mvp.model.entity.GitHubUser
import com.example.githubclient.mvp.model.repository.GitHubUsersRepo
import com.example.githubclient.mvp.model.repository.IGitHubUsersRepo
import com.example.githubclient.mvp.presenter.list.IUserListPresenter
import com.example.githubclient.mvp.view.UserItemView
import com.example.githubclient.mvp.view.UsersView
import com.example.githubclient.navigator.Screens
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(
    val mainThreadScheduler: Scheduler,
    val usersRepo: IGitHubUsersRepo,
    val router: Router
) :
    MvpPresenter<UsersView>() {

    class UserListPresenter : IUserListPresenter {
        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null


        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            user.login?.let { view.setLogin(it)}
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
            .subscribe({ repos ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(repos)
                viewState.updateList()},
                { error -> println("Ошибка: ${error}") })

    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}