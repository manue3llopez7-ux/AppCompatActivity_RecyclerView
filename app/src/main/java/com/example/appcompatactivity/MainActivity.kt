package com.example.appcompatactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<DataClass>()

        // AJUSTE AQUÍ:
        // Supongamos que renombraste tus archivos a "live_chatbot" y "loader_cat"
        // y los pusiste en la carpeta res/raw

        data.add(DataClass("Asistente Virtual", "Chatbot animado en tiempo real", R.raw.live_chatbot))
        data.add(DataClass("Estado de Carga", "Gatito cargando configuración", R.raw.loader_cat))

        // Si quieres llenar el resto con ejemplos genéricos para probar el scroll:
        for (i in 3..10) {
            data.add(DataClass("Elemento $i", "Descripción del item $i", R.raw.live_chatbot))
        }

        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter
    }
}