package com.example.mealsmenu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealsmenu.R
import com.example.mealsmenu.adapters.CategoryMealsAdapter
import com.example.mealsmenu.viewmodels.BaseViewModel

abstract class BaseCategoryFragment : Fragment() {
    private lateinit var baseViewModel: BaseViewModel
    private lateinit var adapter: CategoryMealsAdapter

    abstract fun initViewModel(): BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_base_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseViewModel = initViewModel()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        adapter = CategoryMealsAdapter(emptyList())
        recyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted {
            baseViewModel.meal.collect {
                when {
                    !it.meals.isNullOrEmpty() -> {
                        adapter.setCocktails(it.meals)
                    }
                    !it.errorMessage.isNullOrEmpty() -> {
                        Toast.makeText(
                            requireContext(), it.errorMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}