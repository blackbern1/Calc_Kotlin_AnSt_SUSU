package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button;
import android.widget.EditText;

class MainActivity : ComponentActivity() {
    private lateinit var buttonEqual: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var buttonPlus: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDevide: Button
    private lateinit var buttonDot: Button
    private lateinit var buttonRemove: Button
    private lateinit var buttonCancel: Button
    private lateinit var buttonHistory: Button
    private lateinit var textResult: EditText
    private lateinit var editText: EditText

    private var calculated = false
    private var lastValue = 0f
    private var iqualPressed = false
    private var signPressed = ' '
    private var valuesArray = mutableListOf<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eArr = intent.getFloatArrayExtra("backArray")
        if (eArr != null) {
            for(value in eArr)
            {
                valuesArray.add(value)
            }
        }

        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonPlus = findViewById(R.id.buttonPlus)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDevide = findViewById(R.id.buttonDevide)
        buttonDot = findViewById(R.id.buttonDot)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonRemove = findViewById(R.id.buttonRemove)
        buttonCancel = findViewById(R.id.buttonCancel)
        buttonHistory = findViewById(R.id.buttonHistory)

        editText = findViewById(R.id.editText)
        textResult = findViewById(R.id.editEqual)

        button0.setOnClickListener {
            if (calculated)
            {
                textResult.text.clear()
            }
            if (editText.text.length == 1 && editText.text.contains('0')) {
                return@setOnClickListener
            }
            editText.text.append('0')
        }
        button1.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('1')
        }
        button2.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('2')
        }
        button3.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('3')
        }
        button4.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('4')
        }
        button5.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('5')
        }
        button6.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('6')
        }
        button7.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('7')
        }
        button8.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('8')
        }
        button9.setOnClickListener {
            if (editText.text.length == 1 && editText.text.contains('0')) {
                editText.text.clear()
            }
            editText.text.append('9')
        }
        buttonCancel.setOnClickListener(){
            editText.text.clear()
            editText.text.append('0')
            textResult.text.clear()
            calculated = false
            iqualPressed = false
            signPressed = ' '
        }
        buttonRemove.setOnClickListener(){
            if (calculated)
            {
                editText.text.clear()
                editText.text.append('0')
            }
            if (editText.text.length == 1)
            {
                editText.setText("0")
                return@setOnClickListener
            }
            val txt = editText.text.toString()
            val newText = txt.substring(0, txt.length - 1)
            editText.setText(newText)
        }
        buttonPlus.setOnClickListener(){
            if (calculated)
            {
                textResult.text.clear()
                textResult.text.append(editText.text)
                textResult.text.append('+')
            }
            if (textResult.text.isEmpty())
            {
                val txt = editText.text.toString()
                val newText = txt.substring(0, txt.length)
                textResult.setText(newText)
                textResult.text.append('+')
            }
            if (textResult.text.contains('-') ||
                textResult.text.contains('*') ||
                textResult.text.contains('/'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.setText(newText)
                textResult.text.append('+')
            }
            editText.text.clear()
            editText.text.append('0')
            signPressed = '+'
        }
        buttonMinus.setOnClickListener(){
            if (calculated)
            {
                textResult.text.clear()
                textResult.text.append(editText.text)
                textResult.text.append('-')
            }
            if (textResult.text.isEmpty())
            {
                val txt = editText.text.toString()
                val newText = txt.substring(0, txt.length)
                textResult.setText(newText)
                textResult.text.append('-')
            }
            if (textResult.text.contains('+') ||
                textResult.text.contains('*') ||
                textResult.text.contains('/'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.setText(newText)
                textResult.text.append('-')
            }
            editText.text.clear()
            editText.text.append('0')
            signPressed = '-'
        }
        buttonMultiply.setOnClickListener(){
            if (calculated)
            {
                textResult.text.clear()
                textResult.text.append(editText.text)
                textResult.text.append('*')
            }
            if (textResult.text.isEmpty())
            {
                val txt = editText.text.toString()
                val newText = txt.substring(0, txt.length)
                textResult.setText(newText)
                textResult.text.append('*')
            }
            if (textResult.text.contains('+') ||
                textResult.text.contains('-') ||
                textResult.text.contains('/'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.setText(newText)
                textResult.text.append('*')
            }
            editText.text.clear()
            editText.text.append('0')
            signPressed = '*'
        }
        buttonDevide.setOnClickListener(){
            if (calculated)
            {
                textResult.text.clear()
                textResult.text.append(editText.text)
                textResult.text.append('/')
            }
            if (textResult.text.isEmpty())
            {
                val txt = editText.text.toString()
                val newText = txt.substring(0, txt.length)
                textResult.setText(newText)
                textResult.text.append('/')
            }
            if (textResult.text.contains('+') ||
                textResult.text.contains('-') ||
                textResult.text.contains('*'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.setText(newText)
                textResult.text.append('/')
            }
            editText.text.clear()
            editText.text.append('0')
            signPressed = '/'
        }
        buttonEqual.setOnClickListener(){
            if (editText.text[editText.text.length-1] == '.')
                return@setOnClickListener
            if(iqualPressed) {
                val txt = lastValue.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.setText(newText)
                textResult.text.append(signPressed)
            }
            if (textResult.text.contains('+'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.text.append(editText.text)
                textResult.text.append('=')
                val value = newText.toFloat()
                val txt2 = editText.text.toString()
                val value2 = txt2.toFloat()
                if (!iqualPressed)
                    lastValue = value2

                editText.text.clear()
                val result = value + value2
                valuesArray.add(result)
                editText.text.append(result.toString())
            }
            else if (textResult.text.contains('-'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.text.append(editText.text)
                textResult.text.append('=')
                val value = newText.toFloat()
                val txt2 = editText.text.toString()
                val value2 = txt2.toFloat()
                if (!iqualPressed)
                    lastValue = value2

                editText.text.clear()
                val result = value - value2
                valuesArray.add(result)
                editText.text.append(result.toString())
            }
            else if (textResult.text.contains('*'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.text.append(editText.text)
                textResult.text.append('=')
                val value = newText.toFloat()
                val txt2 = editText.text.toString()
                val value2 = txt2.toFloat()
                if (!iqualPressed)
                    lastValue = value2

                editText.text.clear()
                val result = value * value2
                valuesArray.add(result)
                editText.text.append(result.toString())
            }
            else if (textResult.text.contains('/'))
            {
                val txt = textResult.text.toString()
                val newText = txt.substring(0, txt.length - 1)
                textResult.text.append(editText.text)
                textResult.text.append('=')
                val value = newText.toFloat()
                val txt2 = editText.text.toString()
                val value2 = txt2.toFloat()
                if (!iqualPressed)
                    lastValue = value2

                if (value2 == 0f) {
                    editText.text.clear()
                    textResult.text.clear()
                    editText.setText("Cannot / on 0!")
                    return@setOnClickListener
                }
                editText.text.clear()
                val result = value / value2
                valuesArray.add(result)
                editText.text.append(result.toString())
            }
            calculated = true
            iqualPressed = true
        }
        buttonDot.setOnClickListener(){
            if (editText.text.contains('.'))
                return@setOnClickListener
            editText.text.append('.')
        }
        buttonHistory.setOnClickListener(){
            val intent = Intent(this, HistoryActivity::class.java)
            val arr:FloatArray = valuesArray.toFloatArray()
            intent.putExtra("valuesArray", arr)
            startActivity(intent)
        }
    }
}