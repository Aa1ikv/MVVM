package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val model = CounterModel()

    private val _counterData = MutableLiveData<Int>()
    val counterData: LiveData<Int> get() = _counterData

    fun onIncrement() {
        model.increment()
        updateCounter()
    }

    fun onDecrement() {
        model.decrement()
        updateCounter()
    }

    private fun updateCounter() {
        _counterData.value = model.getResult()
    }
}