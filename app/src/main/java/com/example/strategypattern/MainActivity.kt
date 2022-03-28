package com.example.strategypattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.strategypattern.databinding.ActivityMainBinding

/**
 * 2022.3.28    Monday
 * 策略模式Strategy Pattern
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOk.setOnClickListener {
            var siglePrice = binding.etSinglePrice.text.toString()
            var amount = binding.etAmount.text.toString()
            var sumPrice = siglePrice.toDouble() *  amount.toInt()
            val str = "sigle price: " + siglePrice.toDouble() + " amount: " + amount.toInt() + "\nsum: " +  sumPrice
            binding.etDetail.setText(str)
            binding.tvSumPrice.setText(sumPrice.toString())
        }
        binding.btnReset.setOnClickListener(){
            binding.etSinglePrice.setText("")
            binding.etAmount.setText("")
            binding.etDetail.setText("")
            binding.tvSumPrice.setText("")
        }
    }
}