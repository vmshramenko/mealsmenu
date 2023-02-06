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
import com.example.mealsmenu.data.SearchDvo

class SearchMealAdapter(
    private var mList: List<SearchDvo>,
    val clickListener: (idMeal: Int) -> Unit
): RecyclerView.Adapter<SearchMealAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setMeals(search: List<SearchDvo>){
        mList = search
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_search_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        Glide.with(holder.mealImage.context)
            .load(itemsViewModel.image)
            .into(holder.mealImage)

        holder.mealName.text = itemsViewModel.name

        holder.itemView.setOnClickListener {
            clickListener(itemsViewModel.idMeal.toInt())
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val mealImage: ImageView = itemView.findViewById(R.id.meal_image)
        val mealName: TextView = itemView.findViewById(R.id.meal_name)
    }
}