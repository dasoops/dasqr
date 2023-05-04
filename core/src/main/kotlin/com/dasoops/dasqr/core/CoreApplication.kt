package com.dasoops.dasqr.core

import com.dasoops.common.db.ktorm.BaseKtormConfiguration
import kotlinx.coroutines.runBlocking
import org.ktorm.database.Database
import org.ktorm.support.postgresql.PostgreSqlDialect
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.sql.DataSource

@SpringBootApplication(scanBasePackages = ["com"])
@ConfigurationPropertiesScan("com.dasoops.dasqr.core.runner")
class CoreApplication {
    @Configuration
    class KtormConfiguration : BaseKtormConfiguration(PostgreSqlDialect()) {
        override fun getUserId(): Long {
            return 0L
        }
    }
}

fun main(args: Array<String>): Unit = runBlocking {
    SpringApplication.run(CoreApplication::class.java, *args)
}