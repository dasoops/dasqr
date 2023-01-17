/**
 * vo 基类
 */
// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface BaseVo {
}

/**
 * 获取下一个自增主键vo
 */
export interface GetNextRowIdVo extends BaseVo {
    rowId: number;
}