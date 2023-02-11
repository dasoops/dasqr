package com.dasoops.dasserver.plugin.starcraft2.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.FactorDo
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.MutationDo
import com.dasoops.dasserver.plugin.starcraft2.mapper.FactorMapper
import com.dasoops.dasserver.plugin.starcraft2.mapper.MutationMapper
import org.springframework.stereotype.Service

/**
 * @Title: FactorSimpleSql
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.service.impl.FactorSimpleSql
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/11
 * @Version 1.0.0
 * @Description: 因子简单sql
 * @see [FactorSimpleSql]
 */
@Service
open class FactorSimpleSql : ServiceImpl<FactorMapper, FactorDo>()

/**
 * @Title: MutationSimpleSql
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.service.impl.MutationSimpleSql
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/11
 * @Version 1.0.0
 * @Description: 突变简单sql
 * @see [MutationSimpleSql]
 */
@Service
open class MutationSimpleSql : ServiceImpl<MutationMapper, MutationDo>()