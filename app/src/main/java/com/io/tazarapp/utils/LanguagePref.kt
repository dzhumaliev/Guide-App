package com.io.tazarapp.utils

import android.content.Context
import android.content.SharedPreferences

class LanguagePref(context: Context) {

    private var PRIVATE_MODE = 0
    private val KEY = "token"
    private val USER_INFO = "user"
    private val LANGUAGE = "lang"
    private val FIRST = "first"
    private val DEF_VALUE = "empty"
    private val sharedPref: SharedPreferences = context.getSharedPreferences(KEY, PRIVATE_MODE)

    inner class TokenModule {

//        fun getToken(): AuthResponseModel? {
//            val temp = sharedPref.getString(KEY, DEF_VALUE)!!
//
//            return if (temp == DEF_VALUE) {
//                null
//            } else {
//                Gson().fromJson(temp, AuthResponseModel::class.java)
//            }
//        }
//
//        fun saveToken(token: AuthResponseModel?) {
//            val temp = Gson().toJson(token)
//            val editor = sharedPref.edit()
//            editor.putString(KEY, temp)
//            editor.apply()
//        }
//
//        fun deleteToken() {
//            val editor = sharedPref.edit()
//            editor.remove(KEY)
//            editor.apply()
//        }

    }
//
//    inner class UserInfoModule {
//
//        fun getUserInfo(): Profile? {
//            val temp = sharedPref.getString(USER_INFO, DEF_VALUE)!!
//
//            return if (temp == DEF_VALUE) {
//                null
//            } else {
//                Gson().fromJson(temp, Profile::class.java)
//            }
//        }
//
//        fun saveUserInfo(user: Profile?) {
//            val temp = Gson().toJson(user)
//            val editor = sharedPref.edit()
//            editor.putString(USER_INFO, temp)
//            editor.apply()
//        }
//
//        fun deleteUser() {
//            val editor = sharedPref.edit()
//            editor.remove(USER_INFO)
//            editor.apply()
//        }
//    }

    inner class LanguageModule {

        fun getLanguage(): String {
            return sharedPref.getString(LANGUAGE, DEF_VALUE)!!
        }

        fun saveLanguage(string: String) {
            val editor = sharedPref.edit()
            editor.putString(LANGUAGE, string)
            editor.apply()
        }
    }

    inner class FirstTimeModule {

        fun isFirstTime(): Boolean {
            return sharedPref.getBoolean(FIRST, true)
        }

        fun saveFirstTime(bool: Boolean) {
            val editor = sharedPref.edit()
            editor.putBoolean(FIRST, bool)
            editor.apply()
        }
    }

}
