package com.example.mealsmenu.authentication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mealsmenu.R

import com.example.mealsmenu.activity.AppActivity
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        val signGoogleButton = findViewById<Button>(R.id.signInGoogleButton)
        val signLoginButton = findViewById<Button>(R.id.signInLoginButton)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signGoogleButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                if(user != null) {
                    val appIntent = Intent(signGoogleButton.context, AppActivity::class.java)
                    startActivity(appIntent)
                }else{
                    val signGoogle = Intent(signGoogleButton.context, SignInGoogleActivity::class.java)
                    startActivity(signGoogle)
                }
            }
        } )

        signUpButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val signUpIntent = Intent(signUpButton.context, SignUpPasswordActivity::class.java)
                startActivity(signUpIntent)
            }
        })

        signLoginButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val loginIntent = Intent(signLoginButton.context, SignInPasswordActivity::class.java)
                startActivity(loginIntent)
            }
        })
    }
}