package com.dasoops.dasserver.plugin.loaj.entity.param;

import com.dasoops.common.entity.param.base.BaseDeleteParam;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: DeleteReplyParam
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.param.DeleteReplyParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: 删除回复param
 * @see BaseDeleteParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeleteReplyParam extends BaseDeleteParam<ReplyDo> {
}
