package com.dasoops.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.cq.entity.po.RegisterPo;
import com.dasoops.cq.service.RegisterService;
import com.dasoops.cq.mapper.RegisterMapper;
import org.springframework.stereotype.Service;

/**
 * @Title: RegisterServiceImpl
 * @ClassPath com.dasoops.cq.service.impl.RegisterServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_REGISTER(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see RegisterService
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, RegisterPo>
    implements RegisterService{

}




