package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class ImageSliderAdapter(
    private val context: Context
) : RecyclerView.Adapter<ImageSliderAdapter.ViewHolder>() {

    private val colors = arrayListOf(
        android.R.color.holo_red_dark,
        android.R.color.holo_green_dark,
        android.R.color.holo_blue_dark
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image_slider, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = colors.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(color = colors[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var llRoot: LinearLayout? = null

        init {
            llRoot = itemView.findViewById(R.id.llRoot)
        }

        fun bindData(color: Int) {
            llRoot?.setBackgroundColor(ContextCompat.getColor(itemView.context, color))
        }
    }
}