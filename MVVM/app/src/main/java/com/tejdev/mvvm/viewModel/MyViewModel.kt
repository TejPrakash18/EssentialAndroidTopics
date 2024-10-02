package com.tejdev.mvvm.viewModel

import androidx.lifecycle.ViewModel
import com.tejdev.mvvm.Model.CalculatorData

class MyViewModel : ViewModel() {

    fun calculateResult(num1: Int, num2: Int): CalculatorData {
        // Perform the calculation logic here
        val result = num1 + num2
        return CalculatorData( num1, num2, result)

    }
}