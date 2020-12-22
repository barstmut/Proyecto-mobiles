package com.example.proyecto3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.full_service.*

class fullService : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.full_service)

        val bundle = intent.extras
        tv_fullname.text =bundle!!.getString("nombre")
        iv_fullitem.setImageResource(bundle!!.getInt("img"))
    }
}