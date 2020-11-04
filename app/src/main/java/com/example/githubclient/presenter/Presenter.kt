package com.example.githubclient.presenter

import com.example.githubclient.model.Counter
import com.example.githubclient.view.ForViewAndModel

/**
 * Презентер для взаимодействия с View и Model
 */
class Presenter(var interfaceForView: ForViewAndModel.forView): ForViewAndModel.forPresenter {

private var model: Counter = Counter()

    /**
     * В методах initBtn1,initBtn2,initBtn3 происходит создание переменной с увелечением счетчика на +1,
     * запись этих данных в модель
     * и передачи этих данных во View через интерфейс
     */
    override fun initBtn1(index: Int){
        var newValue:Int = calcNewValue(index)
        model.setValueCounter(index,newValue)
        interfaceForView.setBtn1(newValue)
    }

    override fun initBtn2(index: Int) {
        var newValue:Int = calcNewValue(index)
        model.setValueCounter(index,newValue)
        interfaceForView.setBtn2(newValue)
    }

    override fun initBtn3(index: Int) {
        var newValue:Int = calcNewValue(index)
        model.setValueCounter(index,newValue)
        interfaceForView.setBtn3(newValue)
    }

    /**
     * Медод который возвращает увеличеное на 1 значение счетчика (ВОЗМОЖНО НУЖНО ВЫНЕСТИ В МОДЕЛЬ)
     */
    private fun calcNewValue(index:Int):Int{
        return model.getValueCounter(index) + 1
    }
}