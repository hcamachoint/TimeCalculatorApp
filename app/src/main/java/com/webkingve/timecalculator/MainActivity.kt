package com.webkingve.timecalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var textResult : TextView? = null
    var totalizer : Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            clear()
        }

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        btnCalculate.setOnClickListener {
            calculate()
        }
    }

    fun safeToInt(string: String): Int {
        if (string.isNotBlank()) {
            return string.toInt()
        } else {
            return 0
        }
    }

    private fun timeCloser(value : Double){
        var filterValue: String? = "%.2f".format(value)
        totalizer += filterValue!!.toDouble()                                                  //FLOAT
        Log.i("App Error", totalizer.toString())

        var resultSimple = totalizer.toString().split(".")      //STRING
        var resultOne = safeToInt(resultSimple[0])
        var resultTwo = safeToInt(resultSimple[1])
        var resultDecimal = ""

        if (resultTwo >= 60){
            resultOne += 1
            resultTwo -= 60

            resultDecimal = if(resultTwo < 10){
                "0$resultTwo"
            }else{
                resultTwo.toString()
            }
        }else if(resultTwo == 6){
            resultOne += 1
            resultDecimal = "0"
        }else{
            resultDecimal = resultTwo.toString()
        }
        Log.i("App Error Debug", resultDecimal)
        totalizer = ("${resultOne}.$resultDecimal").toDouble()
    }

    fun calculate(){
        totalizer = 0.00
        var textResult = findViewById<TextView>(R.id.textResult)
        var tvOne = findViewById<EditText>(R.id.timeOne).text
        var tvTwo = findViewById<EditText>(R.id.timeTwo).text
        var tvThree = findViewById<EditText>(R.id.timeThree).text
        var tvFour = findViewById<EditText>(R.id.timeFour).text
        var tvFive = findViewById<EditText>(R.id.timeFive).text
        var tvSix = findViewById<EditText>(R.id.timeSix).text
        var tvSeven = findViewById<EditText>(R.id.timeSeven).text

        try {
            if(tvOne.isNotEmpty()){
                timeCloser(tvOne.toString().toDouble())
            }
            if(tvTwo.isNotEmpty()){
                timeCloser(tvTwo.toString().toDouble())
            }
            if(tvThree.isNotEmpty()){
                timeCloser(tvThree.toString().toDouble())
            }
            if(tvFour.isNotEmpty()){
                timeCloser(tvFour.toString().toDouble())
            }
            if(tvFive.isNotEmpty()){
                timeCloser(tvFive.toString().toDouble())
            }
            if(tvSix.isNotEmpty()){
                timeCloser(tvSix.toString().toDouble())
            }
            if(tvSeven.isNotEmpty()){
                timeCloser(tvSeven.toString().toDouble())
            }
            textResult.text = totalizer.toString()
        }catch(e: Exception) {
            Toast.makeText(this, "Algo ha fallado", Toast.LENGTH_LONG).show()
            Log.i("App Error", e.toString())
        }
    }

    private fun clear(){
        try {
            //textResult?.text = "0.00"
            //timeOne?.requestFocus()
        }catch (e: Exception){
            Toast.makeText(this, "Algo ha fallado", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}