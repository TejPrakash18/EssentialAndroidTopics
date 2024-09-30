package com.tejdev.livedata.LiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveViewModel: ViewModel() {

    private val countLiveData = MutableLiveData<Int>()

    init {
        countLiveData.value = 0
    }
    val counterLiveData:LiveData<Int>
        get() = countLiveData

    fun incrementCount(){
        countLiveData.value = (countLiveData.value?:0)+1
    }
    fun decrementCount(){
        countLiveData.value = (countLiveData.value?:0)-1
    }

}