package com.example.mvvm

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.counterData.observe(this) { count ->
            binding.tvCount.text = count.toString()

            when (count) {
                10 -> showCongratulations()
                15 -> changeTextColorToGreen()
                else -> resetTextColor()
            }
        }

        binding.btnDecrement.setOnClickListener {
            viewModel.onDecrement()
        }

        binding.btnIncrement.setOnClickListener {
            viewModel.onIncrement()
        }
    }

    private fun showCongratulations() {
        Toast.makeText(this, "Поздравляем! Достигли 10!", Toast.LENGTH_SHORT).show()
    }

    private fun changeTextColorToGreen() {
        binding.tvCount.setTextColor(Color.GREEN)
    }

    private fun resetTextColor() {
        binding.tvCount.setTextColor(Color.BLACK)
    }
}