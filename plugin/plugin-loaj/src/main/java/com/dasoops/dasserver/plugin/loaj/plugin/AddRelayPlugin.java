package com.dasoops.dasserver.plugin.loaj.plugin;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.cq.utils.DqCodeUtil;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajKeyEnum;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: AddRelayPlugin
 * @ClassPath com.dasoops.dasserver.plugin.loaj.plugin.AddRelayPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 添加回复插件
 */
@Slf4j
@Component
public class AddRelayPlugin extends CqPlugin {

    private final StringRedisTemplate stringRedisTemplate;
    private final ReplyService replyService;

    public AddRelayPlugin(@SuppressWarnings("all") StringRedisTemplate stringRedisTemplate, ReplyService replyService) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.replyService = replyService;
    }

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    private PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent event) {
        final String prefix = "addRelay";
        String message = event.getMessage();
        if (!StrUtil.startWithIgnoreCase(message, prefix)) {
            return PassObj.pass(event);
        }
        List<String> paramStrList = DqCodeUtil.getParamStr(message, prefix);
        //参数校验
        if (ObjUtil.isEmpty(paramStrList) || paramStrList.size() < 2) {
            cqTemplate.sendMsg(event, "怎么这都不会");
            //发送cbcbcbccb
            cqTemplate.sendMsg(event, CqCodeUtil.image("980d4eaa-a536-4f4c-b160-7e8a13f3ce04.jpg"));
            return PassObj.block();
        }
        // addReply ping,pong
        String keyword = paramStrList.get(0);
        String reply = paramStrList.get(1);
        // 组装 持久化
        ReplyDo replyPo = new ReplyDo();
        replyPo.setKeyword(keyword);
        replyPo.setReply(reply);
        replyService.save(replyPo);
        stringRedisTemplate.opsForHash().put(LoajKeyEnum.REPLY.getKey(), keyword, reply);
        cqTemplate.sendMsg(event, "已阅");
        return PassObj.block();
    }


}
