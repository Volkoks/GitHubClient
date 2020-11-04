package com.example.githubclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubclient.presenter.Presenter
import com.example.githubclient.view.ForViewAndModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ForViewAndModel.forView {

    private val presenter: Presenter? by lazy {
        Presenter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_counter_1.setOnClickListener { presenter?.initBtn1(0) }
        btn_counter_2.setOnClickListener { presenter?.initBtn2(1) }
        btn_counter_3.setOnClickListener { presenter?.initBtn3(2) }

    }

    override fun setBtn1(value: Int) {
        btn_counter_1.text = "Количество = $value"
    }

    override fun setBtn2(value: Int) {
        btn_counter_2.text = "Количество = $value"
    }

    override fun setBtn3(value: Int) {
        btn_counter_3.text = "Количество = $value"
    }
}