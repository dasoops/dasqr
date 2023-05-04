package com.dasoops.dasqr.plugin

import com.dasoops.dasqr.core.CoreApplication
import kotlinx.coroutines.runBlocking
import org.springframework.boot.SpringApplication

fun main(args: Array<String>): Unit = runBlocking {
    SpringApplication.run(CoreApplication::class.java, *args)
}