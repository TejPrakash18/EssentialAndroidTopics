package com.tejdev.mvvm.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.tejdev.mvvm.R
import com.tejdev.mvvm.databinding.ActivityMainBinding
import com.tejdev.mvvm.viewModel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myviewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myviewModel = ViewModelProvider(this).get(MyViewModel::class.java)

binding.addbtn.setOnClickListener{
    val num1 = binding.num1.text.toString().toIntOrNull()?:0
    val num2 = binding.num2.text.toString().toIntOrNull()?:0
    val result = myviewModel.calculateResult(num1, num2)
    binding.result.text = result.result.toString()
}



    }
}