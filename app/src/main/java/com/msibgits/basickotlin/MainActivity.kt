package com.msibgits.basickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.msibgits.basickotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        setupView()
    }

    private fun setupView() {
        binding.btnOperatorPlus.setOnClickListener {
            // 10 + 3 = 13
            val result = calculate(10, 3, Operator.PLUS)
            println(result)
            showToast(result)
        }

        binding.btnOperatorMin.setOnClickListener {
            // 12 - 3 = 9
            val result = calculate(12, 3, Operator.MINUS)
            println(result)
            showToast(result.toString())
        }

        binding.btnOperatorTimes.setOnClickListener {
            // 10 * 4 = 40
            val result = calculate(10, 4, Operator.TIMES)
            println(result)
            showToast(result.toString())
        }

        binding.btnOperatorDiv.setOnClickListener {
            // 10 / 2 = 5
            val result = calculate(10, 2, Operator.DIV)
            println(result)
            showToast(result.toString())
        }

        binding.btnOperatorModulus.setOnClickListener {
            // 10 % 3 = 1
            val result = calculate(10, 3, Operator.MOD)
            println(result)
            showToast(result.toString())
        }
    }

    private fun calculate(num1: Int, num2: Int, operator: Operator): String {
        return when (operator) {
            Operator.PLUS -> {
                val calculate = num1.plus(num2).toLong()
                "$num1 + $num2 = $calculate"
            }
            Operator.MINUS -> {
                val calculate = num1.minus(num2).toLong()
                "$num1 - $num2 = $calculate"
            }
            Operator.TIMES -> {
                val calculate = num1.times(num2).toLong()
                "$num1 * $num2 = $calculate"
            }
            Operator.DIV -> {
                val calculate = num1.div(num2).toLong()
                "$num1 / $num2 = $calculate"
            }
            Operator.MOD -> {
                val calculate = num1.mod(num2).toLong()
                "$num1 % $num2 = $calculate"
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}

enum class Operator {
    PLUS, MINUS, TIMES, DIV, MOD
}