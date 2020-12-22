package com.example.proyecto3

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.servicio.view.*

class lista : AppCompatActivity(), SensorEventListener
{
    var listaservicios = ArrayList<servicio>()
    var adapter:servAdapter?=null

    var sensor:Sensor?=null
    var sensorManager: SensorManager?=null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        listaservicios.add(servicio("Academia","Academia Wind Ninja",R.drawable.wind,"si","56966649869"))

        adapter = servAdapter(this,listaservicios)
        gv.adapter = adapter

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    class servAdapter:BaseAdapter
    {
        var listaservicios = ArrayList<servicio>()
        var contexto: Context?=null

        constructor(contexto: Context, listaservicios:ArrayList<servicio>):super()
        {
            this.contexto = contexto
            this.listaservicios = listaservicios
        }
        override fun getCount(): Int
        {
            return listaservicios.size
        }

        override fun getItem(position: Int): Any
        {
            return listaservicios[position]
        }

        override fun getItemId(position: Int): Long
        {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
        {
            var serv = listaservicios[position]
            var inflator = contexto!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vistaServicios = inflator.inflate(R.layout.servicio,null)

            var vibrator: Vibrator?=null

            vistaServicios.ib_item.setImageResource(serv.imagen!!)
            vistaServicios.tv_nombre.text = serv.nombre

            vistaServicios.Cuadro.setOnClickListener{
                val intent = Intent(contexto,fullService::class.java)
                intent.putExtra("nombre",serv.nombre)
                intent.putExtra("url",serv.url)
                intent.putExtra("phone",serv.phone)
                intent.putExtra("img",serv.imagen)

                contexto!!.startActivity(intent)

                val vibe: Vibrator = contexto?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibe.vibrate(1000)

            }
            return vistaServicios

        }


    }

    override fun onSensorChanged(p0: SensorEvent?) {
        TODO("Not yet implemented")
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }
}