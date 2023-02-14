package com.dasoops.dasserver.plugin.webmanager.util

class RegisterFantasyUtil {

    companion object{
        fun isMatch(string: String): Boolean {
            return string.startsWith("_")
        }
    }



}