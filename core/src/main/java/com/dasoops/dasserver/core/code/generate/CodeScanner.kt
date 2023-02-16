package com.dasoops.dasserver.core.code.generate

class CodeScanner {

    companion object {
        fun scan() {

            val classLoader = this::class.java.classLoader
            val resources = classLoader.getResources("/")

        }
    }
}