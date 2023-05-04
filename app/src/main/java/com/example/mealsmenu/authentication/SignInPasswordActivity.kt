package com.example.mealsmenu.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mealsmenu.R
import com.example.mealsmenu.activity.AppActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_password)
        auth = Firebase.auth
        val signInButton = findViewById<Button>(R.id.signInButton)
        val password = findViewById<EditText>(R.id.passwordEditText)
        val email = findViewById<EditText>(R.id.emailEditText)

        signInButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val pass = password.text.toString()
                val email = email.text.toString()
                signIn(email, pass)
            }
        })

    }

    private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("EmailPassword", "signInWithEmail:success")
                    val user = auth.currentUser
                    val intent = Intent(this, AppActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("EmailPassword", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        // [END sign_in_with_email]
    }
}