package com.myapp.mentalfire3

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.Display

class SharedPreferences(context: Context) {

    val keynumber = "key"
    val number = ""
    val spinner = "false1"
    val disappear = "false2"
    val comparison = "false3"
    val book = "false4"
    val polarity = "false5"
    val five = "false6"
    val nothing = "false7"
    val problem = "false8"
    val anchor = "falseg"
    val time = "falser"
    val fear = "fakse"
    val decart = "falsed"
    val theme = "system"
    val adBlock = "false9"
    val adPlus = "false10"
    val notifications = "false11"

    var sp = context.getSharedPreferences(keynumber, Context.MODE_PRIVATE)

    fun deleteData() {
        sp.edit().clear().apply()
    }

    fun getNumber(): Int {
        return sp.getInt(number, 0)
    }

    fun setNumber(n : Int) {
        val editor = sp.edit()
        editor.putInt(number, n)
        editor.apply()
    }

    fun getSpinner() : Boolean {
        return sp.getBoolean(spinner, false)
    }

    fun setSpinner(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(spinner, value)
        editor.apply()
    }

    fun getDisappear() : Boolean {
        return sp.getBoolean(disappear, false)
    }

    fun setDisappear(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(disappear, value)
        editor.apply()
    }

    fun getComparison() : Boolean {
        return sp.getBoolean(comparison, false)
    }

    fun setComparison(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(comparison, value)
        editor.apply()
    }

    fun getBook() : Boolean {
        return sp.getBoolean(book, false)
    }

    fun setBook(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(book, value)
        editor.apply()
    }

    fun getPolarity() : Boolean {
        return sp.getBoolean(polarity, false)
    }

    fun setPolarity(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(polarity, value)
        editor.apply()
    }

    fun getFive() : Boolean {
        return sp.getBoolean(five, false)
    }

    fun setFive(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(five, value)
        editor.apply()
    }

    fun getNothing() : Boolean {
        return sp.getBoolean(nothing, false)
    }

    fun setNothing(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(nothing, value)
        editor.apply()
    }

    fun getProblem() : Boolean {
        return sp.getBoolean(problem, false)
    }

    fun setProblem(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(problem, value)
        editor.apply()
    }

    fun getAnchor() : Boolean {
        return sp.getBoolean(anchor, false)
    }

    fun setAnchor(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(anchor, value)
        editor.apply()
    }

    fun getTime() : Boolean {
        return sp.getBoolean(time, false)
    }

    fun setTime(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(time, value)
        editor.apply()
    }

    fun getFear() : Boolean {
        return sp.getBoolean(fear, false)
    }

    fun setFear(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(fear, value)
        editor.apply()
    }

    fun getDecart() : Boolean {
        return sp.getBoolean(decart, false)
    }

    fun setDecart(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(decart, value)
        editor.apply()
    }

    fun getTHeme() : String {
        return sp.getString(theme, "system")!!
    }

    fun setTheme(value : String) {
        val editor = sp.edit()
        editor.putString(theme, value)
        editor.apply()
    }

    fun getAdBlock() : Boolean {
        return sp.getBoolean(adBlock, false)
    }

    @SuppressLint("CommitPrefEdits")
    fun setAdBlock(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(adBlock, value)
        editor.apply()
    }

    fun getAdPlus() : Boolean {
        return sp.getBoolean(adPlus, false)
    }

    fun setAdPlus(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(adPlus, value)
        editor.apply()
    }

    fun getNotification() : Boolean {
        return sp.getBoolean(notifications, true)
    }

    fun setNotification(value : Boolean) {
        val editor = sp.edit()
        editor.putBoolean(notifications, value)
        editor.apply()
    }

}