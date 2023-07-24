package com.dasoops.dasqr.plugin.ktorm

import cn.hutool.db.ds.pooled.DbConfig
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.common.db.ktorm.KtormRunner
import com.dasoops.common.json.core.parse
import com.dasoops.dasqr.core.util.get
import com.dasoops.dasqr.core.runner.Runner
import org.ktorm.database.detectDialectImplementation
import org.ktorm.logging.Slf4jLoggerAdapter

/**
 * ktorm启动类
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/17
 */
open class DasqrKtormRunner : KtormRunner(), Runner {
    override val level = Runner.Level.BEFORE_ALL

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