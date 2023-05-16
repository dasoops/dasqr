package com.dasoops.dasqr.core

import com.dasoops.common.db.ktorm.BaseKtormConfiguration
import kotlinx.coroutines.runBlocking
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import java.util.*

@SpringBootApplication(scanBasePackages = ["com"])
@ConfigurationPropertiesScan("com.dasoops.dasqr.core.runner")
class CoreApplication {
    @Configuration
    class KtormConfiguration : BaseKtormConfiguration() {
        override fun getUserId(): Long {
            return 0L
        }
    }
}

fun main(args: Array<String>): Unit = runBlocking {
    SpringApplication.run(CoreApplication::class.java, *args)
}