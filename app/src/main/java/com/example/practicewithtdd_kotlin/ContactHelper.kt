package com.example.practicewithtdd_kotlin

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ContactHelper (private val sharedPreferences: SharedPreferences) {
    fun getContactsList (): List<Contact> {
        val list = sharedPreferences.getString("contacts", "[]")
        val turnsType = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(list, turnsType)
    }

    fun setContactsList (list: List<Contact>) {
        sharedPreferences.edit().putString("contacts", Gson().toJson(list)).commit()
    }
}