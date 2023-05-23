package com.dasoops.dasqr.plugin

import com.dasoops.dasqr.core.runner.InitRunner
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>): Unit = runBlocking {
    InitRunner.init()
}