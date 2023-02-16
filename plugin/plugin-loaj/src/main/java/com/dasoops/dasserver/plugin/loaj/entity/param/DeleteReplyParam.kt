package com.dasoops.dasserver.plugin.loaj.entity.param

import com.dasoops.common.entity.param.base.BaseDeleteParam
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import lombok.Data
import lombok.EqualsAndHashCode

/**
 * @title DeleteReplyParam
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.param.DeleteReplyParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/15
 * @Version 1.0.0
 * @Description: 删除回复param
 * @see [DeleteReplyParam]
 */
@ApiModel(value = "删除回复param", description = "删除回复param")
@Api("Reply")
class DeleteReplyParam : BaseDeleteParam<ReplyDo>()