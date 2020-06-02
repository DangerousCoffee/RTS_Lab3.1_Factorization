package com.example.factor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        super.setTitle("Factor")

        button.setOnClickListener() {
            calculate()
        }
    }

    fun calculate() {
        val number: String = num_field.getText().toString()
        val factor = Factor()
        var factorized: MutableList<Long> = ArrayList()
        factor.prime_factor(number.toLong())

        factorized = factor.factorized
        var string: String = "Number " + number + " is factorized to " + factorized[0]

        for (index in 1 until factorized.size)
            string += " * " + factorized[index].toString()
        result_text.setText(string)

        var iter_string = "Iteration num: "
        iter_string += factor.get_iter().toString()
        Toast.makeText(applicationContext, iter_string, Toast.LENGTH_LONG).show()
    }
}

