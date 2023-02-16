package com.dasoops.dasserver.plugin.starcraft2.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.FactorDo
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.MutationDo
import com.dasoops.dasserver.plugin.starcraft2.mapper.FactorMapper
import com.dasoops.dasserver.plugin.starcraft2.mapper.MutationMapper
import org.springframework.stereotype.Service

/**
 * @title FactorSimpleSql
 * @classPath com.dasoops.dasserver.plugin.starcraft2.service.impl.FactorSimpleSql
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/11
 * @version 1.0.0
 * @description 因子简单sql
 * @see [FactorSimpleSql]
 */
@Service
open class FactorSimpleSql : ServiceImpl<FactorMapper, FactorDo>()

/**
 * @title MutationSimpleSql
 * @classPath com.dasoops.dasserver.plugin.starcraft2.service.impl.MutationSimpleSql
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/11
 * @version 1.0.0
 * @description 突变简单sql
 * @see [MutationSimpleSql]
 */
@Service
open class MutationSimpleSql : ServiceImpl<MutationMapper, MutationDo>()