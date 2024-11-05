package com.example.cityapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val categories: List<Category>,
    private val onClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, onClick)
    }

    override fun getItemCount(): Int = categories.size

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val categoryTextView: TextView = view.findViewById(R.id.category_name)
        private val categoryImageView: ImageView = view.findViewById(R.id.category_image)

        fun bind(category: Category, onClick: (Category) -> Unit) {
            categoryTextView.text = category.name
            categoryImageView.setImageResource(category.imageResId)

            itemView.setOnClickListener { onClick(category) }
        }
    }
}
