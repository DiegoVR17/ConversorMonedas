package com.diegovr17.current_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var SpinnerMonOrig: Spinner
    lateinit var SpinnerMonDes: Spinner

    lateinit var ButtonConver: Button

    lateinit var CantiConver: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SpinnerMonOrig = findViewById(R.id.spinMonOrig) as Spinner
        SpinnerMonDes = findViewById(R.id.spinMonDes) as Spinner
        ButtonConver = findViewById(R.id.ButtonConvert) as Button
        CantiConver = findViewById(R.id.Cantidad) as EditText



        var MonOrig = ""
        var MonDes = ""


        var MonedasO = arrayOf("DolaresUS","PesosCol","Euros")
        SpinnerMonOrig.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,MonedasO)
        SpinnerMonOrig.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                MonOrig = MonedasO[position]
            }

        }


        var MonedasD = arrayOf("PesosCol","DolaresUS","Euros")
        SpinnerMonDes.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,MonedasD)
        SpinnerMonDes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                MonDes = MonedasD[position]
            }

        }



        ButtonConver.setOnClickListener(View.OnClickListener{

            var CantC:String = CantiConver.text.toString()
            var CantCon = 0.0f

            when(MonOrig){

                "DolaresUS" ->
                    when(MonDes){
                      "PesosCol" -> CantCon = (CantC.toFloat() * 3322.84).toFloat()
                      "Euros" -> CantCon = (CantC.toFloat() * 0.90).toFloat()
                    else -> tvConversion.text = "Error"
                    }

                "PesosCol" ->
                    when(MonDes){
                        "DolaresUS" ->  CantCon = (CantC.toFloat() * 0.00030).toFloat()
                        "Euros" ->  CantCon = (CantC.toFloat() * 0.00027).toFloat()
                    else -> tvConversion.text = "Error"
                    }

                "Euros" ->
                    when(MonDes){
                        "DolaresUS" -> CantCon = (CantC.toFloat() * 1.11).toFloat()
                        "PesosCol" -> CantCon = (CantC.toFloat() * 3700.21).toFloat()
                    else ->  tvConversion.text = "Error"
                    }

            else -> tvConversion.text = "Error"
            }

            var CantConS : String


            CantConS = CantCon.toInt().toString()
            tvConversion.text = CantC +" "+ MonOrig + " son: " + CantConS + " " + MonDes
            MonOrig = ""
            MonDes = ""
        })






    }
}
