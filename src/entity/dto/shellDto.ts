/**
 * 日志dto
 */
export interface LogDto {
    level: 'INFO' | 'DEBUG' | 'TRACE' | 'ERROR' | 'WARN',
    msg: string
}