package com.icoo.smatching.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import org.jetbrains.anko.defaultSharedPreferences

class PreferenceManager(private val context: Context) {

    companion object {
        private val TOKEN = "TOKEN"
    }

    private val prefs: SharedPreferences by lazy { context.defaultSharedPreferences }

    @Suppress("UNCHECKED_CAST")
    fun <T> findPreference(name: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> Unit
        }
        res as T
    }

    fun <T> putPreference(name: String, value: T) = with(prefs) {
        when (value) {
            is Long -> edit().putLong(name, value).apply()
            is String -> edit().putString(name, value).apply()
            is Int -> edit().putInt(name, value).apply()
            is Boolean -> edit().putBoolean(name, value).apply()
            is Float -> edit().putFloat(name, value).apply()
            else -> Unit
        }
    }
}