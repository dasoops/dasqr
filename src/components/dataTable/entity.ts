export interface DataTableConfig {
    tableConfig?: TableConfig,
    columnConfig?: ColumnConfig[],
}

interface TableConfig {

}

interface ColumnConfig {
    label: string,
    prop: string,
    width?: string | number,
    align?: "center" | "right" | "left",
    sortable?: boolean,
}
