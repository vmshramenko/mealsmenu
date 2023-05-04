package com.example.mealsmenu.authentication

import android.annotation.SuppressLint
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

class SignUpPasswordActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_password)
        supportActionBar?.hide()

        auth = Firebase.auth

        val signUpButton1 = findViewById<Button>(R.id.signUp)
        val emailEdit = findViewById<EditText>(R.id.editEmail)
        val passwordEdit = findViewById<EditText>(R.id.editPassword)
        val passwordRetypeEdit = findViewById<EditText>(R.id.editRetypePassword)
        signUpButton1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val email = emailEdit.text.toString()
                val password = passwordEdit.text.toString()
                val confirmPassword = passwordRetypeEdit.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                    if (password == confirmPassword) {
                        createAccount(email, password)
                        Toast.makeText(signUpButton1.context, "Success!", Toast.LENGTH_LONG).show()
                        val intentSignUp = Intent(signUpButton1.context, AppActivity::class.java)
                        startActivity(intentSignUp)
                    } else {
                        Toast.makeText(
                            signUpButton1.context,
                            "Confirm password is incorrect!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(signUpButton1.context!!, "Fill all fields!", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("SignUp", "createUserWithEmail:success")
                    //val user = auth.currentUser
                } else {
                    Log.w("SignUp", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

}