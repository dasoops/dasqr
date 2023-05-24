package com.dasoops.dasqr.plugin.ktorm

import cn.hutool.db.ds.pooled.DbConfig
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.common.db.ktorm.KtormRunner
import com.dasoops.common.json.parse
import com.dasoops.dasqr.core.loader.get
import com.dasoops.dasqr.core.runner.Runner
import com.dasoops.dasqr.core.runner.RunnerLevel
import org.ktorm.database.detectDialectImplementation
import org.ktorm.logging.Slf4jLoggerAdapter

/**
 * ktorm启动类
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/17
 */
object DasqrKtormRunner : KtormRunner(), Runner {
    override val level = RunnerLevel.BEFORE_ALL

    override suspend fun init() {
        super.init(
            dialect = detectDialectImplementation(),
            logger = Slf4jLoggerAdapter("ktorm-log"),
            dbConfig = Resources.get("sqlConfig.json").readText().parse(DbConfig::class.java)
        )
    }

    override fun getUserId(): Long {
        return 0L
    }
}