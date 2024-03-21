package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity

class HistoryActivity : ComponentActivity() {

    private var arr = mutableListOf<Float>()
    private lateinit var buttonBack: Button
    private lateinit var buttonSort: Button
    private lateinit var arrayText: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        buttonBack = findViewById(R.id.buttonBack)
        buttonSort = findViewById(R.id.buttonSort)
        arrayText = findViewById(R.id.arrayText)


        val eArr = intent.getFloatArrayExtra("valuesArray")
        if (eArr != null) {
            for(value in eArr)
            {
                arr.add(value)
            }
        }
        val adapter = ArrayAdapter<Float>(this, android.R.layout.simple_list_item_1,arr)
        arrayText.adapter = adapter
        buttonBack.setOnClickListener(){
            val intentToMain = Intent(this@HistoryActivity, MainActivity::class.java)
            intentToMain.putExtra("backArray", arr.toFloatArray())
            startActivity(intentToMain)
        }
        buttonSort.setOnClickListener(){
            arr.sort()
            val temp = ArrayAdapter<Float>(this, android.R.layout.simple_list_item_1,arr)
            arrayText.adapter = temp
        }

    }
}