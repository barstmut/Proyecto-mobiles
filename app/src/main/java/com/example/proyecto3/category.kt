package com.example.proyecto3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class category : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
    }

    fun list_click(view: View)
    {
        val intent: Intent = Intent(this, lista::class.java)
        startActivity(intent)
    }
}