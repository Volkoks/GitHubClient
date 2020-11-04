package com.example.githubclient.model

/**
 * Класс со значениями счётчика
 */
class Counter {

    private val counter = mutableListOf<Int>(0, 0, 0)

    /**
     * Метод получение значения по индексу из листа
     */
    fun getValueCounter(index: Int): Int {
        return counter.get(index)
    }

    /**
     * Метод записи занчения по определенному индексу
     */
    fun setValueCounter(index: Int, value: Int) {
        counter.set(index, value)
    }

}