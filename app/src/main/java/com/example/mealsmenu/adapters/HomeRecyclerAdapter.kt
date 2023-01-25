package com.example.mealsmenu.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealsmenu.R
import com.example.mealsmenu.data.Meal

class HomeRecyclerAdapter(
    private var mList: List<Meal>
) : RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {
    @SuppressLint("NotifyDataSetChanged")
    fun setMeals(meals: List<Meal>) {
        mList = meals
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_home_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        Glide.with(holder.imageView.context)
            .load(itemsViewModel.strMealThumb)
            .into(holder.imageView)

        holder.textView.text = itemsViewModel.strMeal


    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.meal_image)
        val textView: TextView = itemView.findViewById(R.id.meal_name)
    }
}