package com.example.githubclient.view

/**
 * Общий интерфейс для View и Presenter
 */
interface ForViewAndModel {
    /**
     * Подинтерфейс для View
     */
    interface forView {
        fun setBtn1(value:Int)
        fun setBtn2(value:Int)
        fun setBtn3(value:Int)
    }


    /**
     * Подинтерфейс для Presenter
     */
    interface forPresenter {
        fun initBtn1()
        fun initBtn2()
        fun initBtn3()
    }
}