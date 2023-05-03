package com.dasoops.dasqr.core.mapping.log.exception

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * 针对表【core_exception_log(异常记录表)】的数据库操作Mapper
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-01
 */
@Mapper
interface ExceptionLogMapper : BaseMapper<ExceptionLogDo>