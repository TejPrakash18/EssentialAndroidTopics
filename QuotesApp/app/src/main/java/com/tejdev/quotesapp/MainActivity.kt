package com.tejdev.quotesapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.tejdev.quotesapp.databinding.ActivityMainBinding
import com.tejdev.quotesapp.model.QuoteModel
import com.tejdev.quotesapp.viewModel.RetrofitInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getQuote()

        binding.nextBtn.setOnClickListener{
            getQuote()
        }

}

    private fun getQuote(){
        setInProgress(true)
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.quoteApi.getQuotes()
                if (response.isSuccessful && response.body() != null) {
                    setInProgress(false)
                    setUI(response.body()!!)
                } else {
                    setInProgress(false)
                    Toast.makeText(applicationContext, "Failed to fetch quote", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                setInProgress(false)
                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setUI(quote: QuoteModel){
        binding.quoteTv.text = quote.q
        binding.authorTv.text = quote.a
    }


    private fun setInProgress(inProgress : Boolean){
        if(inProgress){
            binding.progressBar.visibility = View.VISIBLE
            binding.nextBtn.visibility = View.GONE
        }else{
            binding.progressBar.visibility = View.GONE
            binding.nextBtn.visibility = View.VISIBLE
        }
    }
}