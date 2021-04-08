package online.zhaozhe.core.utils

import android.content.Context

import android.content.SharedPreferences

import online.zhaozhe.core.BaseApplication
import online.zhaozhe.core.R


object CacheUtils {
    private val context: Context = BaseApplication.currentApplication

    private val SP: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) = SP.edit().putString(key, value).apply()


    fun get(key: String?) = SP.getString(key, null)

}