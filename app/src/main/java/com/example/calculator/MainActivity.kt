package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1EditText = findViewById(R.id.number1)
        number2EditText = findViewById(R.id.number2)
        resultTextView = findViewById(R.id.result)
        addButton = findViewById(R.id.buttonAdd)
        subtractButton = findViewById(R.id.buttonSubtract)
        multiplyButton = findViewById(R.id.buttonMultiply)
        divideButton = findViewById(R.id.buttonDivide)

        addButton.setOnClickListener { performOperation("+") }
        subtractButton.setOnClickListener { performOperation("-") }
        multiplyButton.setOnClickListener { performOperation("*") }
        divideButton.setOnClickListener { performOperation("/") }
    }

    private fun performOperation(operation: String) {
        try {
            val num1 = number1EditText.text.toString().toDouble()
            val num2 = number2EditText.text.toString().toDouble()
            val result: Double = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> {
                    if (num2 != 0.0) {
                        num1 / num2
                    } else {
                        resultTextView.text = "Cannot divide by zero"
                        return
                    }
                }
                else -> 0.0
            }
            resultTextView.text = result.toString()
        } catch (e: NumberFormatException) {
            resultTextView.text = "Invalid input"
        }
    }
}
