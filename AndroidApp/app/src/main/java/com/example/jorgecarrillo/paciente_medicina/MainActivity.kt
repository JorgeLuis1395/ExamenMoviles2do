package com.example.jorgecarrillo.paciente_medicina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    var tipoUsuario = arrayOf("Item 1", "Item 2", "Item 3")
    var spinner:Spinner? = null
    var textView_msg:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spinner!!.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoUsuario)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)

    }
    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        textView_msg!!.text = "Selected : "+tipoUsuario[position]
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }
}
