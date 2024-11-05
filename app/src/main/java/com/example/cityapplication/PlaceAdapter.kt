package com.example.cityapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapter(private val places: Array<Place>, private val onClick: (Place) -> Unit) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val placeImage: ImageView = view.findViewById(R.id.place_image)
        val placeName: TextView = view.findViewById(R.id.place_name)

        init {
            view.setOnClickListener {
                onClick(places[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.placeName.text = places[position].name
        holder.placeImage.setImageResource(places[position].imageResId)
    }

    override fun getItemCount(): Int = places.size
}
