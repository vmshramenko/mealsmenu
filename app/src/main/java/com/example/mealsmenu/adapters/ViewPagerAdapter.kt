package com.example.mealsmenu.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mealsmenu.fragments.*

class ViewPagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BeefFragment()
            1 -> BreakfastFragment()
            2 -> ChickenFragment()
            3 -> DessertFragment()
            4 -> GoatFragment()
            5 -> LambFragment()
            6 -> MiscellaneousFragment()
            7 -> PastaFragment()
            8 -> PorkFragment()
            9 -> SeafoodFragment()
            10 -> SideFragment()
            11 -> StarterFragment()
            12 -> VeganFragment()
            13 -> VegetarianFragment()
            else -> BeefFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Beef"
            1 -> "Breakfast"
            2 -> "Chicken"
            3 -> "Dessert"
            4 -> "Goat"
            5 -> "Lamb"
            6 -> "Miscellaneous"
            7 -> "Pasta"
            8 -> "Pork"
            9 -> "Seafood"
            10 -> "Side"
            11 -> "Starter"
            12 -> "Vegan"
            13 -> "Vegetarian"
            else -> "Beef"
        }
    }
}