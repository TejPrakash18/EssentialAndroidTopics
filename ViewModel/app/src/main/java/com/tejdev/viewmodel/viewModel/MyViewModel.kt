package com.tejdev.viewmodel.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
private  var count = 0
    fun getIncrementCount():Int{
        return count
    }
    fun updateIncrementCount():Int{
        return ++count
    }
}