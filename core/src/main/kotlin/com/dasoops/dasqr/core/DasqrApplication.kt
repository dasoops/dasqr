package com.dasoops.dasqr.core

import com.dasoops.dasqr.core.loader.DasqrRunner
import com.dasoops.dasqr.core.runner.InitRunner
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>): Unit = runBlocking {
    DasqrRunner.init()
    InitRunner.init()
    while (true) {
        //使用该类打成jar启动莫名其妙直接结束了
    }
}