package com.example.mealsmenu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealsmenu.R
import com.example.mealsmenu.adapters.HomeRecyclerAdapter
import com.example.mealsmenu.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.update

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var breakfastAdapter: HomeRecyclerAdapter
    private lateinit var starterAdapter: HomeRecyclerAdapter
    private lateinit var dessertAdapter: HomeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val recyclerBreakfast = view.findViewById<RecyclerView>(R.id.recycler_breakfast)
        val recyclerStarter = view.findViewById<RecyclerView>(R.id.recycler_starter)
        val recyclerDessert = view.findViewById<RecyclerView>(R.id.recycler_dessert)
        breakfastAdapter = HomeRecyclerAdapter(emptyList())
        starterAdapter = HomeRecyclerAdapter(emptyList())
        dessertAdapter = HomeRecyclerAdapter(emptyList())
        recyclerBreakfast.adapter = breakfastAdapter
        recyclerStarter.adapter = starterAdapter
        recyclerDessert.adapter = dessertAdapter

        lifecycleScope.launchWhenStarted {
            homeViewModel.breakfastMeal.collect {
                when {
                    !it.meals.isNullOrEmpty() -> {
                        breakfastAdapter.setMeals(it.meals)
                    }
                    !it.errorMessage.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            homeViewModel.starterMeal.collect {
                when {
                    !it.meals.isNullOrEmpty() -> {
                        starterAdapter.setMeals(it.meals)
                    }
                    !it.errorMessage.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            homeViewModel.dessertMeal.collect {
                when {
                    !it.meals.isNullOrEmpty() -> {
                        dessertAdapter.setMeals(it.meals)
                    }
                    !it.errorMessage.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}