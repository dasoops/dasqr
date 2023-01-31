/**
 * 表格数据自定义排序通用方法
 */
import {GetPluginPageSortParam} from "@/entity/param/pluginParam";
import {SortParam} from "@/entity/param/baseParam";

export default function () {
    /**
     * 当前点击的表头字段名
     */
    let currentClickColumn = 0;


    /**
     * 手动处理排序
     * @param param0 默认回调参数
     * @param getPluginParam 搜索表单
     * @param loadTableData 获取列表的函数
     * @param getColumnInteger
     */
    const handleSortChange = (
        {column, order}: any,
        getPluginParam: GetPluginPageSortParam,
        loadTableData: any,
        getColumnInteger: (string: string) => number
    ) => {
        if (order) {
            if (!getPluginParam.sortParamList) {
                getPluginParam.sortParamList = []
            }

            let orderInteger: any;
            order === 'ascending' && (orderInteger = 1);
            order === 'descending' && (orderInteger = 0);

            const columnInteger = getColumnInteger(column.label);
            let modify = false;
            for (let i = 0; i < getPluginParam.sortParamList.length; i++) {
                if (getPluginParam.sortParamList[i].sortColumn === columnInteger) {
                    getPluginParam.sortParamList[i].sortRule = orderInteger;
                    modify = true;
                    break;
                }
            }
            if (!modify) {
                getPluginParam.sortParamList.push(new class implements SortParam {
                    sortColumn = columnInteger;
                    sortRule = orderInteger;
                })
            }
            loadTableData();
        } else {
            /**
             * 取消排序时，column, prop, order 都是 null，无法判断是哪一列取消了排序
             * 所以要等 @header-click 事件执行完成，再用当前点击的表头字段名来判断是哪一列
             */
            setTimeout(() => {
                // 清除取消排序的列
                if (getPluginParam.sortParamList) {
                    getPluginParam.sortParamList = getPluginParam.sortParamList.filter(sortParam => sortParam.sortColumn !== currentClickColumn);
                }
                loadTableData()
            }, 0)
        }
    }

    /**
     * 点击表头回调
     * @param column 当前点击列的对象
     * @param getColumnInteger
     */
    const headerClick = (column: any, getColumnInteger: (string: string) => number) => {
        // 把当前点击的表头字段名存起来，后面取消列的排序会用到
        currentClickColumn = getColumnInteger(column.label);
    }

    /**
     * 处理表头样式
     * @param column
     * @param param
     * @param getColumnInteger
     */
    const handleHeaderCellClass = ({column}: any, param: GetPluginPageSortParam, getColumnInteger: (string: string) => number) => {
        /**
         * 遍历更新每一列的排序状态
         * 要用setTimeout等取消列排序的操作执行完成，才去更新表头样式
         */
        setTimeout(() => {
            if (param.sortParamList) {
                for (let i = 0; i < param.sortParamList.length; i++) {
                    const sortParam = param.sortParamList[i];
                    if (sortParam.sortColumn === getColumnInteger(column.label)) {
                        if (sortParam.sortRule === 1) {
                            column.order = 'ascending';
                        } else {
                            column.order = 'descending';
                        }
                    }
                }
            }
        }, 0)
    }

    return {
        handleSortChange,
        headerClick,
        handleHeaderCellClass,
    }

}