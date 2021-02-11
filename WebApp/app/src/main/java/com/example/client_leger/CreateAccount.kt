package com.example.client_leger

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    fun openConnection(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun submit(view: View) {
        view.hideKeyboard()
        val usernameComp = findViewById<EditText>(R.id.etcreateusername)
        val nameComp = findViewById<EditText>(R.id.etcreatename)
        val lastNameComp = findViewById<EditText>(R.id.etcreatelastname)
        val passwordComp = findViewById<EditText>(R.id.etcreatepassword)
        val confirmPasswordComp = findViewById<EditText>(R.id.etconfirmpassword)
        val errorComp = findViewById<TextView>(R.id.tverrorcreate)
        val failComp = findViewById<TextView>(R.id.fail)
        val pwComp = findViewById<TextView>(R.id.pwerror)

        val username = usernameComp.text.toString()
        val name = nameComp.text.toString()
        val lastName = lastNameComp.text.toString()
        val password = passwordComp.text.toString()
        val confirmPassword = confirmPasswordComp.text.toString()


        errorComp.visibility = View.INVISIBLE
        failComp.visibility = View.INVISIBLE
        pwComp.visibility = View.INVISIBLE

        val cleanUser = username.replace("\\s+".toRegex(), "")
        changeToRed(cleanUser, usernameComp)
        val cleanName = name.replace("\\s+".toRegex(), "")
        changeToRed(cleanName, nameComp)
        val cleanLastName = lastName.replace("\\s+".toRegex(), "")
        changeToRed(cleanLastName, lastNameComp)
        val cleanPw = password.replace("\\s+".toRegex(), "")
        changeToRed(cleanPw, passwordComp)
        val cleanConfirmPw = confirmPassword.replace("\\s+".toRegex(), "")
        changeToRed(cleanConfirmPw, confirmPasswordComp)

        if (cleanUser != "" && cleanName != "" && cleanLastName != "" && cleanPw != "" && cleanConfirmPw != "") {
            changeOriginal(usernameComp, nameComp, lastNameComp, passwordComp, confirmPasswordComp)
            if (cleanPw != cleanConfirmPw) {
                pwComp.visibility = View.VISIBLE
            } else {
                //val serverResponse =
                val isUserValid = 1000
                when (isUserValid) {
                    1000 -> {
                        val intent = Intent(this, MainMenu::class.java)
                        startActivity(intent)
                    }
                    1002 -> {
                        errorComp.visibility = View.VISIBLE
                    }
                    else -> {
                        failComp.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun changeToRed(field : String, comp: EditText) {
        if (field == "") {
            comp.background = ContextCompat.getDrawable(this, R.drawable.error_text_edit)
        }
    }

    private fun changeOriginal(usernameComp: EditText, nameComp: EditText,lastNameComp: EditText,
                               passwordComp: EditText, confirmPasswordComp: EditText) {
        usernameComp.background = ContextCompat.getDrawable(this, R.drawable.edit_text)
        nameComp.background = ContextCompat.getDrawable(this, R.drawable.edit_text)
        lastNameComp.background = ContextCompat.getDrawable(this, R.drawable.edit_text)
        passwordComp.background = ContextCompat.getDrawable(this, R.drawable.edit_text)
        confirmPasswordComp.background = ContextCompat.getDrawable(this, R.drawable.edit_text)
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
