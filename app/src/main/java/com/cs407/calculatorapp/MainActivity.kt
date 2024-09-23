package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivide = findViewById<Button>(R.id.button_divide)


        buttonAdd.setOnClickListener {
            performOperation(input1, input2, "add")
        }

        buttonSubtract.setOnClickListener {
            performOperation(input1, input2, "subtract")
        }

        buttonMultiply.setOnClickListener {
            performOperation(input1, input2, "multiply")
        }

        buttonDivide.setOnClickListener {
            performOperation(input1, input2, "divide")
        }
    }

    private fun performOperation(input1: EditText, input2: EditText, operation: String) {

        val num1 = input1.text.toString().toFloatOrNull()
        val num2 = input2.text.toString().toFloatOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Please enter valid numbers!", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> if (num2 != 0.0f) num1 / num2 else "Error: Divide by zero"
            else -> "Unknown operation"
        }

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", result.toString())
        startActivity(intent)
    }
}
