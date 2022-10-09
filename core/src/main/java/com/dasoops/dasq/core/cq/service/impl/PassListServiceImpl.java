package com.dasoops.dasq.core.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.cq.service.PassListService;
import com.dasoops.dasq.core.cq.entity.pojo.PassObject;
import com.dasoops.dasq.core.cq.mapper.PassListMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【TB_SYS_PASS_LIST(过滤白名单)】的数据库操作Service实现
* @createDate 2022-10-07 16:40:31
*/
@Service
public class PassListServiceImpl extends ServiceImpl<PassListMapper, PassObject>
    implements PassListService {

}




