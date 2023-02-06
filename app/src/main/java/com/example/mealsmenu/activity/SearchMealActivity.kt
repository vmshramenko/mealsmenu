package com.example.mealsmenu.activity

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealsmenu.R
import com.example.mealsmenu.adapters.SearchMealAdapter
import com.example.mealsmenu.viewmodels.MealDetailsViewModel
import com.example.mealsmenu.viewmodels.SearchMealViewModel

class SearchMealActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_meal)
        supportActionBar?.hide()
        val search = findViewById<SearchView>(R.id.search_meal)
        val recyclerSearch = findViewById<RecyclerView>(R.id.recycler_search)
        val textError = findViewById<TextView>(R.id.not_found)
        val adapter =
            SearchMealAdapter(emptyList(), clickListener = { id -> launchMealDetails(id) })
        recyclerSearch.adapter = adapter

        var searchViewModel: SearchMealViewModel = ViewModelProvider(this, viewModelFactory {
            SearchMealViewModel(search.query.toString())
        }
        )[SearchMealViewModel::class.java]
        lifecycleScope.launchWhenStarted {
            searchViewModel.search.collect {
                if (it.search != null) {
                    textError.isVisible = false
                    recyclerSearch.isVisible = true
                    adapter.setMeals(it.search)
                    Log.d("adapter set result", it.search.toString())
                    if (it.search.isEmpty()) {
                        adapter.setMeals(emptyList())
                        recyclerSearch.isVisible = false
                        textError.isVisible = true
                    }
                }
            }
        }
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchViewModel = SearchMealViewModel(query)

                lifecycleScope.launchWhenStarted {
                    searchViewModel.search.collect {
                        if (it.search != null) {
                            textError.isVisible = false
                            recyclerSearch.isVisible = true
                            adapter.setMeals(it.search)
                            Log.d("adapter set result", it.search.toString())
                            if (it.search.isEmpty()) {
                                adapter.setMeals(emptyList())
                                recyclerSearch.isVisible = false
                                textError.isVisible = true
                            }
                        }
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchViewModel = SearchMealViewModel(newText)

                lifecycleScope.launchWhenStarted {
                    searchViewModel.search.collect {
                        if (it.search != null) {
                            textError.isVisible = false
                            recyclerSearch.isVisible = true
                            adapter.setMeals(it.search)
                            Log.d("adapter set result", it.search.toString())
                            if (it.search.isEmpty()) {
                                adapter.setMeals(emptyList())
                                recyclerSearch.isVisible = false
                                textError.isVisible = true
                            }
                        }
                    }
                }
                return false
            }
        })
    }

    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T = f() as T
        }

    private fun launchMealDetails(id: Int) {
        Log.d(ContentValues.TAG, "SENT id drink = $id")
        val intent = Intent(this, MealDetailsActivity::class.java)
        intent.putExtra("idDrink", id.toString())
        startActivity(intent)
    }
}