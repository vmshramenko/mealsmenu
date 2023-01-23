package com.example.mealsmenu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mealsmenu.R
import com.example.mealsmenu.viewmodels.BaseViewModel
import com.example.mealsmenu.viewmodels.BreakfastViewModel
import com.example.mealsmenu.viewmodels.GoatViewModel

class GoatFragment : BaseCategoryFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_goat, container, false)
    }

    override fun initViewModel(): BaseViewModel {
        return ViewModelProvider(this)[GoatViewModel::class.java]
    }
}