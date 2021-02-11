package com.example.client_leger

import android.R.color
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun connectionValidation(view: View) {
        view.hideKeyboard()
        val usernameComp = findViewById<EditText>(R.id.etusername)
        val username = usernameComp.text.toString()
        val passwordComp = findViewById<EditText>(R.id.etpassword)
        val password = passwordComp.text.toString()
        val errorComp = findViewById<TextView>(R.id.tverror)

        val cleanUser = username.replace("\\s+".toRegex(), "")
        val cleanPw = password.replace("\\s+".toRegex(), "")

        if (cleanUser != "" && cleanPw != "") {
            val isValid = 1000 //validation with server

            when (isValid) {
                1000 -> {
                    val intent = Intent(this, MainMenu::class.java)
                    startActivity(intent)
                }
                1002 -> {

                }
                else -> {
                    //usernameComp.background = ContextCompat.getDrawable(this, R.drawable.edit_text)
                    //passwordComp.background = ContextCompat.getDrawable(this, R.drawable.edit_text)
                    errorComp.visibility = View.VISIBLE
                }
            }
        } else {
            errorComp.visibility = View.INVISIBLE
            if (cleanUser == "") {
                usernameComp.setError("Entrez un nom d\'utilisateur")
            }
            if (cleanPw == "") {
                passwordComp.setError("Entrez un mot de passe")
            }
        }

    }

    fun openCreateAccount(view: View) {
        val intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {}

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}