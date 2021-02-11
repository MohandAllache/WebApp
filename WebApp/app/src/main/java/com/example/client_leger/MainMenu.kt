package com.example.client_leger

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class MainMenu : AppCompatActivity() {

    //ChatButtons
    private lateinit var listActiveChat : ListView
    private lateinit var listJoinChat: ListView
    private lateinit var layoutCreateChat : ConstraintLayout
    private lateinit var activeChat : TextView
    private lateinit var joinChat : TextView
    private lateinit var createChat : TextView

    //MainMenuButtons
    private lateinit var layoutPlayMenu : ConstraintLayout
    private lateinit var layoutProfilMenu : ConstraintLayout
    private lateinit var layoutTutorialMenu : ConstraintLayout
    private lateinit var layoutSettingsMenu : ConstraintLayout
    private lateinit var playMenu : TextView
    private lateinit var profilMenu : TextView
    private lateinit var tutorialMenu : TextView
    private lateinit var settingsMenu : TextView


    private lateinit var inputMessage : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        // initializes components
        listActiveChat = findViewById<ListView>(R.id.listActive)
        listJoinChat = findViewById<ListView>(R.id.listJoin)
        layoutCreateChat = findViewById<ConstraintLayout>(R.id.clcreategame)
        activeChat = findViewById<TextView>(R.id.tvactive)
        joinChat = findViewById<TextView>(R.id.tvjoin)
        createChat = findViewById<TextView>(R.id.tvcreate)

        layoutPlayMenu = findViewById<ConstraintLayout>(R.id.clplaymenu)
        layoutProfilMenu = findViewById<ConstraintLayout>(R.id.clprofilmenu)
        layoutTutorialMenu = findViewById<ConstraintLayout>(R.id.cltutorialmenu)
        layoutSettingsMenu = findViewById<ConstraintLayout>(R.id.cloptionsmenu)
        playMenu = findViewById<TextView>(R.id.tvplay)
        profilMenu = findViewById<TextView>(R.id.tvprofil)
        tutorialMenu = findViewById<TextView>(R.id.tvtutorial)
        settingsMenu = findViewById<TextView>(R.id.tvoptions)

        inputMessage = findViewById<EditText>(R.id.etmessageinput)

        // opens active chat
        updateActiveChat(listActiveChat)
    }

    fun updateActiveChat(view: View) {
        hideAllTabsChat()
        activeChat.background = ContextCompat.getDrawable(this, R.drawable.active_tab)
        activeChat.setTextColor(ContextCompat.getColor(this, R.color.purple_light))
        listActiveChat.visibility = View.VISIBLE
        // val serverResponse =
        val activeChat = ArrayList<String>(2) // serverResponse.size
        activeChat.add("ROOM 0")
        activeChat.add("ROOM 1")
        activeChat.add("ROOM 2")
        activeChat.add("ROOM 3")
        activeChat.add("ROOM 4")
        activeChat.add("ROOM 5")
        activeChat.add("ROOM 6")
        activeChat.add("ROOM 7")
        activeChat.add("ROOM 8")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, activeChat)
        listActiveChat.adapter = adapter
        listActiveChat.setOnItemClickListener{parent, view, position, id ->

            //Toast.makeText(this@MainActivity, "You have Clicked " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
            listActiveChat.visibility = View.GONE
            inputMessage.visibility = View.VISIBLE
        }
    }

    fun updateJoinChat(view: View) {
        hideAllTabsChat()
        joinChat.background = ContextCompat.getDrawable(this, R.drawable.active_tab)
        joinChat.setTextColor(ContextCompat.getColor(this, R.color.purple_light))
        listJoinChat.visibility = View.VISIBLE
        // val serverResponse =
        val joinChat = ArrayList<String>(2) // serverResponse.size
        joinChat.add("CHAT 0")
        joinChat.add("CHAT 1")
        joinChat.add("CHAT 2")
        joinChat.add("CHAT 3")
        joinChat.add("CHAT 4")
        joinChat.add("CHAT 5")
        joinChat.add("CHAT 6")
        joinChat.add("CHAT 7")
        joinChat.add("CHAT 8")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, joinChat)
        listJoinChat.adapter = adapter
    }

    fun openCreateChat(view: View) {
        hideAllTabsChat()
        createChat.background = ContextCompat.getDrawable(this, R.drawable.active_tab)
        createChat.setTextColor(ContextCompat.getColor(this, R.color.purple_light))
        layoutCreateChat.visibility = View.VISIBLE
    }

    private fun hideAllTabsChat() {
        listActiveChat.visibility = View.GONE
        listJoinChat.visibility = View.GONE
        layoutCreateChat.visibility = View.GONE
        activeChat.background = ContextCompat.getDrawable(this, R.drawable.non_active_tab)
        joinChat.background = ContextCompat.getDrawable(this, R.drawable.non_active_tab)
        createChat.background = ContextCompat.getDrawable(this, R.drawable.non_active_tab)
        activeChat.setTextColor(ContextCompat.getColor(this, R.color.white))
        joinChat.setTextColor(ContextCompat.getColor(this, R.color.white))
        createChat.setTextColor(ContextCompat.getColor(this, R.color.white))
    }

    fun openPlayMenu(view: View) {
        hideAllTabsMenu()
        playMenu.background = ContextCompat.getDrawable(this, R.drawable.active_tab)
        playMenu.setTextColor(ContextCompat.getColor(this, R.color.purple_light))
        layoutPlayMenu.visibility = View.VISIBLE
    }
    fun openProfilMenu(view: View) {
        hideAllTabsMenu()
        profilMenu.background = ContextCompat.getDrawable(this, R.drawable.active_tab)
        profilMenu.setTextColor(ContextCompat.getColor(this, R.color.purple_light))
        layoutProfilMenu.visibility = View.VISIBLE
    }
    fun openTutorialMenu(view: View) {
        hideAllTabsMenu()
        tutorialMenu.background = ContextCompat.getDrawable(this, R.drawable.active_tab)
        tutorialMenu.setTextColor(ContextCompat.getColor(this, R.color.purple_light))
        layoutTutorialMenu.visibility = View.VISIBLE
    }
    fun openSettingsMenu(view: View) {
        hideAllTabsMenu()
        settingsMenu.background = ContextCompat.getDrawable(this, R.drawable.active_tab)
        settingsMenu.setTextColor(ContextCompat.getColor(this, R.color.purple_light))
        layoutSettingsMenu.visibility = View.VISIBLE
    }


    private fun hideAllTabsMenu() {
        playMenu.background = ContextCompat.getDrawable(this, R.drawable.non_active_tab)
        profilMenu.background = ContextCompat.getDrawable(this, R.drawable.non_active_tab)
        tutorialMenu.background = ContextCompat.getDrawable(this, R.drawable.non_active_tab)
        settingsMenu.background = ContextCompat.getDrawable(this, R.drawable.non_active_tab)

        playMenu.setTextColor(ContextCompat.getColor(this, R.color.white))
        profilMenu.setTextColor(ContextCompat.getColor(this, R.color.white))
        tutorialMenu.setTextColor(ContextCompat.getColor(this, R.color.white))
        settingsMenu.setTextColor(ContextCompat.getColor(this, R.color.white))

        layoutPlayMenu.visibility = View.GONE
        layoutProfilMenu.visibility = View.GONE
        layoutTutorialMenu.visibility = View.GONE
        layoutSettingsMenu.visibility = View.GONE
    }

    fun logout(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}