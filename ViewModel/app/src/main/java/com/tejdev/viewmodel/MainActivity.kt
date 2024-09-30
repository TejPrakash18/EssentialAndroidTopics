package com.tejdev.viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.tejdev.viewmodel.databinding.ActivityMainBinding
import com.tejdev.viewmodel.viewModel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.counter.text = myViewModel.getIncrementCount().toString()

        binding.btnIncrement.setOnClickListener {
            binding.counter.text = myViewModel.updateIncrementCount().toString()

        }
    }
}