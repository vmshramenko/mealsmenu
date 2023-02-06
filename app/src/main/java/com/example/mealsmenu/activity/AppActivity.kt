package com.example.mealsmenu.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mealsmenu.R
import com.example.mealsmenu.fragments.BeefFragment
import com.example.mealsmenu.fragments.CatalogFragment
import com.example.mealsmenu.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppActivity : AppCompatActivity() {
    lateinit var selectedFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        supportActionBar?.hide()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.setOnItemSelectedListener(navListener)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment())
            .commit()
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when (it.itemId) {
            R.id.home -> {
                selectedFragment = HomeFragment()
            }
           R.id.catalog -> {
                selectedFragment = CatalogFragment()
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, selectedFragment).commit()
        true
    }
}