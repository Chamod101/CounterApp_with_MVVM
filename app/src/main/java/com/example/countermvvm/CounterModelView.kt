package com.example.countermvvm

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterModelView() : ViewModel (){

    private val _repository: CounterRepository = CounterRepository()
    private val _counter = mutableIntStateOf(_repository.getCounter().count)

    //Exposed to view
    val count : MutableState<Int> = _counter

    fun increment(){
        _repository.incrementCounter()
        _counter.value = _repository.getCounter().count
    }

    fun decrement(){
        _repository.decrementCounter()
        _counter.value = _repository.getCounter().count
    }
}