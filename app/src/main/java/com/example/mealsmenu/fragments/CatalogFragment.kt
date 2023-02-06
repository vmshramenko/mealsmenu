package com.example.mealsmenu.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.example.mealsmenu.R
import com.example.mealsmenu.activity.SearchMealActivity
import com.example.mealsmenu.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch

class CatalogFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = view.findViewById<View>(R.id.search_meals)
        val viewPager = view.findViewById<ViewPager>(R.id.view_pager)
        val tabCocktails = view.findViewById<TabLayout>(R.id.meal_tab)
        val adapter = ViewPagerAdapter(parentFragmentManager, tabCocktails.tabCount)
        lifecycleScope.launch {
            viewPager.adapter = adapter
            tabCocktails.setupWithViewPager(viewPager)
        }

        searchView.setOnClickListener {
            val intent = Intent(it.context, SearchMealActivity::class.java)
            startActivity(intent)
        }
    }
}