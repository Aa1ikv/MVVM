package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val model = CounterModel()
    val counterData = MutableLiveData<Int>()


    fun onIncrement(){
        model.increment()
        counterData.value = model.getResult()
    }

    fun onDecrement(){
        model.decrement()
        counterData.value = model.getResult()
    }
}