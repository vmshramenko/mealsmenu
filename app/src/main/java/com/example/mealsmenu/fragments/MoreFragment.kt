package com.example.mealsmenu.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mealsmenu.R
import com.example.mealsmenu.authentication.AuthActivity
import com.google.firebase.auth.FirebaseAuth


class MoreFragment : Fragment() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signOutButton = view.findViewById<Button>(R.id.signOut)
        val user = mAuth.currentUser
        signOutButton.setOnClickListener ( object: View.OnClickListener{
            override fun onClick(v: View?) {
                    mAuth.signOut()
                    val intent = Intent(view.context, AuthActivity::class.java)
                    intent.putExtra("user", " ")
                    startActivity(intent)
            }
        })
    }

}