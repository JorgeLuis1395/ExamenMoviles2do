package com.example.jorgecarrillo.paciente_medicina

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    var tipoUsuario = arrayOf("Paciente", "Medicina", "Delivery")
    var spinner:Spinner? = null
    var textView_msg:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = this.spinner1
        spinner!!.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoUsuario)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)


    }
    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
       Log.d("Erroe" , "Selected : "+tipoUsuario[position])
        Log.d("Erroe" , "Selected : "+editTextNombreUsuario.text.toString())
        if(tipoUsuario[position] == "Paciente" && editTextNombreUsuario.text.toString() == "Jorge"  && editTextContraseña.text.toString() == "1234") {
            Log.d("Erroe", "Bienvenido al Sistema")
                    title_activity_login.setOnClickListener { v: View? ->
                irActividadPaciente()
            }
        }

            if(tipoUsuario[position] == "Medicina" && editTextNombreUsuario.text.toString() == "Luis"  && editTextContraseña.text.toString() == "root"){
                Log.d("Erroe" , "Bienvenido al Sistema")
                title_activity_login.setOnClickListener{
                    v: View? ->  irActividadMedicina()
                }
        }
            if(tipoUsuario[position] == "Delivery" && editTextNombreUsuario.text.toString() == "Pepe"  && editTextContraseña.text.toString() == "Pepe1234") {
                Log.d("Erroe", "Bienvenido al Sistema")
                title_activity_login.setOnClickListener { v: View? ->
                    irActividadDelivery()
                }
            }

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }
    fun irActividadPaciente(){
        var intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }
    fun irActividadMedicina(){
        var intent = Intent(this, MedicinaActivity::class.java)
        startActivity(intent)
    }
    fun irActividadDelivery(){
        var intent = Intent(this, DeliveryActivity::class.java)
        startActivity(intent)
    }
}
