package com.webkingve.timecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var textResult : TextView? = null
    private var timeOne : TextView? = null
    private var timeTwo : TextView? = null
    private var timeThree : TextView? = null
    private var timeFour : TextView? = null
    private var timeFive : TextView? = null
    private var timeSix : TextView? = null
    private var timeSeven : TextView? = null
    var totalizer : Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.textResult)
        timeOne = findViewById(R.id.timeOne)
        timeTwo = findViewById(R.id.timeTwo)
        timeThree = findViewById(R.id.timeThree)
        timeFour = findViewById(R.id.timeFour)
        timeFive = findViewById(R.id.timeFive)
        timeSix = findViewById(R.id.timeSix)
        timeSeven = findViewById(R.id.timeSeven)
    }

    private fun timeCloser(value : Double){
        totalizer += value                                                  //FLOAT

        var resultSimple = totalizer.toString().split(".")      //STRING
        var resultOne = resultSimple[0].toInt()
        var resultTwo = resultSimple[1].toInt()
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
        totalizer = ("${resultOne}.$resultDecimal").toDouble()
        textResult?.text = "Hours: $totalizer"
    }

    fun onCalculate(view: View){
        var tvOne = timeOne?.text
        var tvTwo = timeTwo?.text
        var tvThree = timeThree?.text
        var tvFour = timeFour?.text
        var tvFive = timeFive?.text
        var tvSix = timeSix?.text
        var tvSeven = timeSeven?.text
        totalizer = 0.00

        try {
            if (tvOne != null) {
                if(tvOne.isNotEmpty()){
                    timeCloser(tvOne.toString().toDouble())
                }
            }
            if (tvTwo != null) {
                if(tvTwo.isNotEmpty()){
                    timeCloser(tvTwo.toString().toDouble())
                }
            }
            if (tvThree != null) {
                if(tvThree.isNotEmpty()){
                    timeCloser(tvThree.toString().toDouble())
                }
            }
            if (tvFour != null) {
                if(tvFour.isNotEmpty()){
                    timeCloser(tvFour.toString().toDouble())
                }
            }
            if (tvFive != null) {
                if(tvFive.isNotEmpty()){
                    timeCloser(tvFive.toString().toDouble())
                }
            }
            if (tvSix != null) {
                if(tvSix.isNotEmpty()){
                    timeCloser(tvSix.toString().toDouble())
                }
            }
            if (tvSeven != null) {
                if(tvSeven.isNotEmpty()){
                    timeCloser(tvSeven.toString().toDouble())
                }
            }
        }catch(e: Exception) {
            Toast.makeText(this, "Algo ha fallado: $e", Toast.LENGTH_LONG).show()
        }
    }

    fun onClear(view : View){
        try {
            timeOne?.text = ""
            timeTwo?.text = ""
            timeThree?.text = ""
            timeFour?.text = ""
            timeFive?.text = ""
            timeSix?.text = ""
            timeSeven?.text = ""
            textResult?.text = "Hours: 0.00"
            timeOne?.requestFocus()
        }catch (e: Exception){
            Toast.makeText(this, "Algo ha fallado", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}