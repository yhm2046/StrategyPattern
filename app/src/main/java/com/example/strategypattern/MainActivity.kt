package com.example.strategypattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Switch
import com.example.strategypattern.databinding.ActivityMainBinding

/**
 * 2022.3.28    Monday
 * 策略模式Strategy Pattern
 */
class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity_tag"
    var discount_num = 0.0
    var discount_str = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOk.setOnClickListener {
            var siglePrice = binding.etSinglePrice.text.toString()
            var amount = binding.etAmount.text.toString()
            var sumPrice = siglePrice.toDouble() *  amount.toInt()

            when(discount_num){
                    0.0 -> discount_str = "正常"
                    0.8 -> {
                        sumPrice *= 0.8
                        discount_str = "打八折"
                    }
                    0.5 -> {
                        sumPrice *= 0.5
                        discount_str = "打五折"
                    }
                }
            val str = "sigle price: " + siglePrice.toDouble() + " amount: " + amount.toInt() + "\n"+discount_str + " sum: " +  sumPrice
            binding.etDetail.setText(str)
            binding.tvSumPrice.setText(sumPrice.toString())
        }
        binding.btnReset.setOnClickListener(){
            binding.etSinglePrice.setText("")
            binding.etAmount.setText("")
            binding.etDetail.setText("")
            binding.tvSumPrice.setText("")
        }
//        discount
        val discount = resources.getStringArray(R.array.Discount)
        if (binding.spDiscount != null) {
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,discount)
            binding.spDiscount.adapter = adapter
            binding.spDiscount.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    when(discount[position]){
                        "NO" -> discount_num
                        "80%" -> discount_num = 0.8
                        "50%" -> discount_num = 0.5
                    }
                    Log.i(TAG,"click " + discount_num)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}