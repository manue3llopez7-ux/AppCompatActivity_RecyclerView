package com.example.appcompatactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// 1. Importante importar la librería de Lottie
import com.airbnb.lottie.LottieAnimationView

class CustomAdapter(private val mList: List<DataClass>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.textViewTitulo.text = item.titulo
        holder.textViewDesc.text = item.descripcion

        // 2. Usar setAnimation para cargar el JSON y playAnimation para que se mueva
        holder.lottieView.setAnimation(item.imagen)
        holder.lottieView.playAnimation()
    }

    override fun getItemCount(): Int = mList.size

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        // 3. Cambiamos ImageView por LottieAnimationView
        val lottieView: LottieAnimationView = itemView.findViewById(R.id.item_image)
        val textViewTitulo: TextView = itemView.findViewById(R.id.item_title)
        val textViewDesc: TextView = itemView.findViewById(R.id.item_description)
    }
}