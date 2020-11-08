package com.example.githubclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubclient.mvp.presenter.MainPresenter
import com.example.githubclient.mvp.view.MainView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(),MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    private val navigatorHolder = GitHubApp.navigateHolder()
    private val navigator = SupportAppNavigator(this,supportFragmentManager,R.id.container)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

}