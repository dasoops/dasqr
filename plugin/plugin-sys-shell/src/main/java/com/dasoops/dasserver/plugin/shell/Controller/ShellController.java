package com.dasoops.dasserver.plugin.shell.Controller;

import com.dasoops.common.entity.vo.result.Result;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.plugin.shell.entity.enums.ShellRedisHashKeyEnum;
import com.dasoops.dasserver.plugin.shell.entity.vo.GetWsUrlVo;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: ShellController
 * @ClassPath com.dasoops.dasserver.plugin.shell.Controller.ShellController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/24
 * @Version 1.0.0
 * @Description: shell控制器
 */
@RestController
@RequestMapping("shell")
@Api(tags = "plugin-sys-shell")
@RequiredArgsConstructor
@ApiSupport(author = "DasoopsNicole@gmail.com")
public class ShellController {

    private final ConfigCache configCache;

    @GetMapping("getWsUrl")
    @ApiOperation(value = "获取WebSocket连接Url", notes = "获取WebSocket连接Url")
    public Result<GetWsUrlVo> getWsUrl() {
        String wsUrl = configCache.getStringConfig(ShellRedisHashKeyEnum.WEB_SOCKET_URL);
        GetWsUrlVo getWsUrlVo = new GetWsUrlVo();
        getWsUrlVo.setWsUrl(wsUrl);
        return Result.success(getWsUrlVo);
    }

}
