package com.tejdev.livedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tejdev.livedata.LiveData.LiveViewModel
import com.tejdev.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LiveViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(LiveViewModel::class.java)
        setContentView(binding.root)

        viewModel.counterLiveData.observe(this){
            count -> binding.data.text = count.toString()
        }

        binding.positive.setOnClickListener {
            viewModel.incrementCount()
        }

        binding.negative.setOnClickListener {
            viewModel.decrementCount()
        }
    }
}