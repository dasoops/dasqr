package com.dasoops.dasserver.plugin.gitnotice.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.dasoops.dasserver.cq.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GitRecord
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.entity.po.GitRecord
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/02
 * @Version 1.0.0
 * @Description: git记录
 * @see BasePo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="TB_PLUGIN_GIT_RECORD")
@Data
public class GitRecord extends BasePo implements Serializable {

    /**
     * COMMIT ID
     */
    private String commitId;

    /**
     * 提交类型
     */
    private String type;

    /**
     * 提交描述
     */
    private String description;

    /**
     * 作者
     */
    private String another;

    /**
     * COMMIT URL
     */
    private String url;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}