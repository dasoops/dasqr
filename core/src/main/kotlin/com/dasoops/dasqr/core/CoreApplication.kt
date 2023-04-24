package com.dasoops.dasqr.core

import kotlinx.coroutines.runBlocking
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CoreApplication

fun main(args: Array<String>): Unit = runBlocking {
    SpringApplication.run(CoreApplication::class.java, *args)
}