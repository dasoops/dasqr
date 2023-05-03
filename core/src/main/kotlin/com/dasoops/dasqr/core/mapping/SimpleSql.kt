package com.dasoops.dasqr.core.mapping

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasqr.core.mapping.conf.ConfigDo
import com.dasoops.dasqr.core.mapping.conf.ConfigMapper
import com.dasoops.dasqr.core.mapping.log.exception.ExceptionLogDo
import com.dasoops.dasqr.core.mapping.log.exception.ExceptionLogMapper
import com.dasoops.dasqr.core.mapping.log.message.MessageLogDo
import com.dasoops.dasqr.core.mapping.log.message.MessageLogMapper
import org.springframework.stereotype.Service

/**
 * 配置简单sql
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-01
 */
@Service
class ConfigSimpleSql : ServiceImpl<ConfigMapper, ConfigDo>()

/**
 * 异常日志简单sql
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-01
 */
@Service
class ExceptionLogSimpleSql : ServiceImpl<ExceptionLogMapper, ExceptionLogDo>()

/**
 * 消息日志简单sql
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-01
 */
@Service
class MessageLogSimpleSql : ServiceImpl<MessageLogMapper, MessageLogDo>()