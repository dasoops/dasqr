package com.dasoops.dasserver.plugin.gitnotice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasserver.plugin.gitnotice.entity.po.GitRecord;
import com.dasoops.dasserver.plugin.gitnotice.service.GitRecordService;
import com.dasoops.dasserver.plugin.gitnotice.mapper.GitRecordMapper;
import org.springframework.stereotype.Service;

/**
 * @Title: GitRecordServiceImpl
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.service.impl.GitRecordServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/02
 * @Version 1.0.0
 * @Description: 针对表【TB_PLUGIN_GIT_RECORD】的数据库操作Service实现
 * @see ServiceImpl
 * @see GitRecordService
 */
@Service
public class GitRecordServiceImpl extends ServiceImpl<GitRecordMapper, GitRecord>
    implements GitRecordService{

}




