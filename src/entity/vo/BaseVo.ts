/**
 * BaseParam.ts
 * @title {title} BaseParam
 * @author {Author} DasoopsNicole@gmail.com
 * @date {Date} 2023-02-17 09:58:10
 * @description {Description} result基类文件
 */

//no import

/**
 * Vo顶层接口
 */
export interface BaseVo {

}

/**
 * 分页vo基类
 */
export interface BasePageVo {
    /**
     * 总记录数
     */
    total: number
}


/**
 * 获取下一个自增主键vo
 */
export interface GetNextRowIdVo extends BaseVo {
    rowId: number;
}