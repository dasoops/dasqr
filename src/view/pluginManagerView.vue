<template>
  <!--  search  -->
  <div style="height: 5%">
    <el-form :model="getPluginParam" class="searchForm" @keydown.enter="loadData">
      <el-row :gutter="35">
        <el-col :offset="1" :span="8">
          <el-form-item label="name || description like" class="text-color">
            <el-input v-model="getPluginParam.keyword" placeholder="% enter %" class="input-line" clearable/>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="status" class="text-color">
            <el-select
                v-model="getPluginParam.statusList"
                multiple
                collapse-tags
                collapse-tags-tooltip
                placeholder="status"
                style="width: 200px"
            >
              <el-option
                  v-for="item in statusOptions"
                  :key="item.value"
                  :label="item.showString"
                  :value="item.value"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
        </el-col>
        <el-col :span="3">
          <el-form-item>
            <el-button :icon="Search" @click="loadData" circle/>
            <span>&nbsp;&nbsp;</span>
            <el-button :icon="Plus" @click="toAdd" circle/>
            <span>&nbsp;&nbsp;</span>
            <el-button :icon="Download" @click="handleExport" circle/>
            <span>&nbsp;&nbsp;</span>
            <el-button :icon="Sort" @click="toSort" circle/>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
  <!--  table  -->
  <div style="height: 88%">
    <el-row class="tableRow" style="height: 100%">
      <el-table
          v-loading="dataMap.isLoading"
          element-loading-background="rgba(43, 43, 43, 0.6)"
          :data="tableData"
          height="100%"
          style="width: 100%"
          empty-text=""
          resizable
          :header-cell-class-name="(params: GetPluginPageSortParam) => handleHeaderCellClass(params,getPluginParam,getColumnInteger)"
          @sort-change="(params: GetPluginPageSortParam) => handleSortChange(params,getPluginParam,loadData,getColumnInteger)"
          @header-click="(column)=>headerClick(column,getColumnInteger)"
      >
        <el-table-column
            prop="showRowId"
            label="id"
            width="70"
            header-align="center"
            align="center"
            sortable="custom"
        >
        </el-table-column>
        <el-table-column
            prop="showName"
            label="name"
            width="300">
        </el-table-column>
        <el-table-column
            prop="showStatus"
            label="status"
            align="center"
            width="80"
        >
        </el-table-column>
        <el-table-column
            prop="level"
            label="level"
            align="center"
            width="100"
            sortable="custom"
        >
        </el-table-column>
        <el-table-column
            prop="order"
            label="order"
            align="center"
            width="100"
            sortable="custom"
        >
        </el-table-column>
        <el-table-column
            prop="classPath"
            label="classPath"
        >
        </el-table-column>
        <el-table-column
            width="110"
        >
          <template v-slot="scope">
            <el-button
                color="#ffffff"
                size="small"
                plain
                @click="toDelete(scope.row)"
                :icon="Delete"
            />
            <el-button
                color="#ffffff"
                size="small"
                plain
                @click="toEdit(scope.row)"
                :icon="Edit"
            />
          </template>
        </el-table-column>
      </el-table>
    </el-row>
  </div>
  <div style="height: 2%"/>
  <!--  page  -->
  <div style="height: 5%">
    <el-row justify="end" class="pageRow">
      <el-pagination
          v-model:current-page="getPluginParam.current"
          v-model:page-size="getPluginParam.size"
          :page-sizes="[16, 32, 64, 128]"
          small
          background
          layout="dataMap.total, sizes, prev, pager, next, jumper"
          :total="dataMap.total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </el-row>
  </div>
  <!--  dialog  -->
  <div class="dialog">
    <el-dialog
        v-model="dataMap.showEditDialog"
        :title="dataMap.editTitle"
        width="30%"
        align-center
        draggable
    >
      <el-form
          :model="editPluginParam"
          label-position="top"
          ref="editFormRef"
          @keydown.enter="handleEdit(editFormRef)"
          :rules="editAndAddRule"
      >
        <el-form-item label="name" prop="name" class="text-color">
          <el-input v-model="editPluginParam.name" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="description" prop="description" class="text-color">
          <el-input v-model="editPluginParam.description" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="classPath" prop="classPath" class="text-color">
          <el-input v-model="editPluginParam.classPath" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="level" class="text-color">
          <el-slider v-model="editPluginParam.level" :min="0" :max="9" :step="1" show-input/>
        </el-form-item>
        <el-form-item label="enable" label-postion="left">
          <el-switch
              v-model="editPluginParam.enable"
              class="mt-2"
              size="large"
              style="margin-left: 24px; --el-switch-on-color: black; --el-switch-off-color: black"
              inline-prompt
              :active-value="1"
              :inactive-value="0"
              :active-icon="Check"
              :inactive-icon="Close"
          />
        </el-form-item>
      </el-form>
      <template #footer>
          <span class="dialog-footer">
            <el-button @click="dataMap.showEditDialog = false">Cancel</el-button>
            <el-button @click="handleEdit(editFormRef)">
              Confirm
            </el-button>
          </span>
      </template>
    </el-dialog>
    <el-dialog
        v-model="dataMap.showAddDialog"
        :title="dataMap.addTitle"
        width="30%"
        align-center
        draggable
    >
      <el-form
          :model="addPluginParam"
          label-position="top"
          ref="addFormRef"
          @keydown.enter="handleAdd(addFormRef)"
          :rules="editAndAddRule"
      >
        <el-form-item label="name" prop="name" class="text-color">
          <el-input v-model="addPluginParam.name" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="description" prop="description" class="text-color">
          <el-input v-model="addPluginParam.description" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="classPath" prop="classPath" class="text-color">
          <el-input v-model="addPluginParam.classPath" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="level" class="text-color">
          <el-slider v-model="addPluginParam.level" :min="0" :max="9" :step="1" show-input/>
        </el-form-item>
        <el-form-item label="enable" label-postion="left">
          <el-switch
              v-model="addPluginParam.enable"
              class="mt-2"
              size="large"
              style="margin-left: 24px; --el-switch-on-color: black; --el-switch-off-color: black"
              inline-prompt
              :active-value="1"
              :inactive-value="0"
              :active-icon="Check"
              :inactive-icon="Close"
          />
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dataMap.showAddDialog = false">Cancel</el-button>
        <el-button @click="handleAdd(addFormRef)">
          Confirm
        </el-button>
      </span>
      </template>
    </el-dialog>
    <el-dialog
        v-model="dataMap.showSortDialog"
        title="Sort Plugin"
        width="30%"
        align-center
    >
      <das-drag @dataChange="handleSortListChange" :sortDataList="dataMap.pluginSortList"/>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dataMap.showSortDialog = false">Cancel</el-button>
        <el-button @click="handleSort">
          Confirm
        </el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import {reactive, ref} from "vue";
import {Check, Close, Delete, Download, Edit, Plus, Search, Sort} from '@element-plus/icons-vue'
import {ElMessageBox, FormInstance, FormRules} from "element-plus";
import {GetPluginVo} from "@/entity/vo/PluginVo";
import {
  AddPluginParam,
  CheckPluginClassPathParam,
  EditPluginParam,
  GetPluginPageSortParam, SortPluginInnerParam, SortPluginParam
} from "@/entity/param/PluginParam";
import {
  addPlugin,
  checkPluginClassPathNoError,
  deletePlugin,
  editPlugin,
  exportAllPlugin,
  getNextPluginId,
  getPluginPage, getPluginSort, sortPlugin
} from "@/request/PluginRequest";
import {simpleExport} from "@/util/DownloadUtil";
import {DeleteParam} from "@/entity/param/BaseParam";
import {PluginShowDto} from "@/entity/dto/PluginDto";
import UseTableSort from "@/composables/use-table-sort";
import DasDrag from "@/components/dasDrag.vue";


//global begin
const dataMap = reactive({
  showEditDialog: false,
  showAddDialog: false,
  showSortDialog: false,
  isLoading: false,
  pluginSortList: [],
  addTitle: '',
  total: 0,
  editTitle: '',
})

//check begin
const checkClassPath = function (rule: any, value: any, callback: any) {
  if (!value || value === '') {
    return callback(new Error('classPath is null'))
  }
  checkPluginClassPathNoError(new class implements CheckPluginClassPathParam {
    classPath = value;
    checkRepeatClassPath = dataMap.showAddDialog ? 1 : 0;
  }).then(res => {
    if (res.code === 200) {
      callback();
    } else {
      callback(new Error(res.msg));
    }
  })
};

//sort begin
const toSort = function () {
  getPluginSort().then(res => {
    dataMap.pluginSortList = res.data.pluginSortList;
    dataMap.showSortDialog = true;
  })
}
const handleSortListChange = function (list) {
  dataMap.pluginSortList = list;
}
const handleSort = function () {
  let i = 0;
  let sortPluginInnerParamList = dataMap.pluginSortList.map(pluginSort => {
    return new class implements SortPluginInnerParam {
      rowId = pluginSort.rowId;
      order = i++;
    }
  })
  sortPlugin(new class implements SortPluginParam {
    sortPluginList = sortPluginInnerParamList;
  }).then(() => {
    dataMap.showSortDialog = false;
    loadData();
  })
}

//search begin
const {handleSortChange, headerClick, handleHeaderCellClass} = UseTableSort()
const getColumnInteger = function (column: string) {
  switch (column) {
    case'id' : {
      return 0;
    }
    case'order' : {
      return 1;
    }
    case'level' : {
      return 2;
    }
  }
  return 5;
}
const statusOptions = [
  {value: 0, showString: '-) 未启用'},
  {value: 1, showString: 'x) 未加载'},
  {value: 2, showString: '√) 已加载'},
  {value: 3, showString: '?) 无记录'},
]
let tableData: PluginShowDto[] = reactive([]);
const getPluginParam: GetPluginPageSortParam = reactive({
  size: 32,
  current: 1,
  statusList: [],
});
const loadData = async function () {
  dataMap.isLoading = true;
  getPluginPage(getPluginParam).then(res => {
    let data = res.data;
    let showData = data.map(vo => {
      let showStatusString: string;
      switch (vo.status) {
        case 0:
          showStatusString = '-';
          break;
        case 1:
          showStatusString = 'x';
          break;
        case 2:
          showStatusString = '√';
          break;
        case 3:
          showStatusString = '?';
          break;
      }
      return new class implements PluginShowDto {
        classPath = vo.classPath;
        description = vo.description;
        enable = vo.enable;
        level = vo.level;
        name = vo.name;
        order = vo.order;
        rowId = vo.rowId;
        status = vo.status;
        showName = vo.name + '(' + vo.description + ')';
        showStatus = showStatusString;
        showRowId = vo.rowId === -1 ? '?' : vo.rowId.toString();
      }
    });
    tableData = reactive(showData);
    dataMap.total = res.total;
    dataMap.isLoading = false;
  })
}
const handleCurrentChange = function (current: number) {
  getPluginParam.current = current;
  loadData();
}
const handleSizeChange = function (size: number) {
  getPluginParam.size = size;
  loadData();
}

//add begin
const editAndAddRule = reactive<FormRules>({
  name: [
    {
      required: true,
      message: 'name is null',
      trigger: 'blur'
    },
  ],
  description: [
    {
      required: true,
      message: 'description is null',
      trigger: 'blur'
    }
  ],
  classPath: [
    {
      required: true,
      trigger: 'blur',
      validator: checkClassPath,
    }
  ],
});
const addFormRef = ref<FormInstance>();
const addPluginParam: AddPluginParam = reactive({
  classPath: '',
  description: '',
  name: '',
  enable: 0,
  level: 0,
})
const toAdd = function () {
  getNextPluginId().then(res => {
    dataMap.addTitle = 'Add ( ' + res.data.rowId + ' )';
  })
  addPluginParam.classPath = '';
  addPluginParam.description = '';
  addPluginParam.enable = 1;
  addPluginParam.level = 4;
  addPluginParam.name = '';
  addFormRef.value?.resetFields();
  dataMap.showAddDialog = true;
}
const handleAdd = function (addFormRef: FormInstance | undefined) {
  if (!addFormRef) {
    return
  }
  addFormRef.validate((isValid => {
    if (!isValid) {
      return false;
    }
    addPlugin(addPluginParam).then(() => {
      dataMap.showAddDialog = false;
      loadData();
    })
  }));

}

//edit begin
const editFormRef = ref<FormInstance>();
const editPluginParam: EditPluginParam = reactive({
  classPath: '',
  description: '',
  enable: 0,
  level: 0,
  name: '',
  rowId: 0,
});
const toEdit = function (rowData: GetPluginVo) {
  dataMap.editTitle = 'Edit (' + rowData.rowId + ": " + rowData.name + ")";
  editFormRef.value?.resetFields();
  editPluginParam.rowId = rowData.rowId;
  editPluginParam.classPath = rowData.classPath;
  editPluginParam.description = rowData.description;
  editPluginParam.enable = rowData.enable;
  editPluginParam.level = rowData.level;
  editPluginParam.name = rowData.name;
  dataMap.showEditDialog = true;
}
const handleEdit = function (editFormRef: FormInstance | undefined) {
  if (!editFormRef) {
    return
  }
  editFormRef.validate((isValid => {
    if (!isValid) {
      return false;
    }
    editPlugin(editPluginParam).then(() => {
      dataMap.showEditDialog = false;
      loadData();
    })
  }));
}

//delete begin
const toDelete = function (rowData: GetPluginVo) {
  ElMessageBox.confirm(
      'You could lose him for long time. Continue?',
      'Warning',
      {
        confirmButtonText: 'OK',
        cancelButtonText: 'Cancel',
        type: 'warning',
      }
  ).then(function () {
    deletePlugin(new class implements DeleteParam {
      rowId = rowData.rowId;
    }).then(() => {
      loadData();
    })
  })
}

//export begin
const handleExport = function () {
  exportAllPlugin().then(res => {
    simpleExport(res);
  })
}

//init begin
const init = function () {
  loadData();
}
init();
</script>

<style lang="scss" scoped>
/* searchForm */
.searchForm :deep {
  .el-tag {
    background: none;
    border: 1px solid white;
    color: white;
  }

  .el-autocomplete {
    width: 100%;
  }

  .el-select {
    --el-select-input-focus-border-color: none;
  }

  .el-input .el-input__wrapper.is-focus {
    border-bottom: 1px solid greenyellow;
  }

  .el-input .el-input__wrapper {
    background-color: rgba(255, 255, 255, 0);
    color: white;
    border-radius: 0;
    border-bottom: 1px solid white;
    box-shadow: 0 0;
  }

  .el-input .el-input__inner {
    color: white;
  }

  .el-button {
    background-color: rgba(255, 255, 255, 0);

    .el-icon {
      color: white;
    }
  }

  .el-button:hover {
    .el-icon {
      color: greenyellow;
    }
  }

  .el-button:active {
    border: 1px solid greenyellow;
  }
}

/* tableRow */
.tableRow {

  padding: 10px;

  :deep .el-button {
    --el-button-hover-text-color: greenYellow !important;
    --el-button-disabled-border-color: grey !important;
    --el-button-disabled-text-color: grey !important;
    background-color: rgba(255, 255, 255, 0);

    .el-icon {
      color: white;
    }
  }

  :deep .el-button:active {
    border: 1px solid greenyellow;
  }

  :deep .el-button:hover {
    .el-icon {
      color: greenyellow;
    }
  }

  :deep .el-table::before {
    left: 0;
    bottom: 0;
    width: 100%;
    height: 0;
  }

  :deep .el-table,
  :deep .el-table th,
  :deep .el-table tr,
  :deep .el-table td {
    color: white;
    background: transparent;
    border: none;
  }

  :deep .el-table th,
  :deep .el-table td {
    border-bottom: 1px solid #ffffff;
  }

  /* 底下的线 */
  :deep .el-table__inner-wrapper::before {
    height: 0;
  }

  /* 斑马纹 */
  :deep .el-table--striped .el-table__body .el-table__row--striped td {
    background-color: rgba(255, 255, 255, 0.05)
  }

  :deep .el-table tbody tr:hover > td {
    background-color: rgba(243, 222, 194, 0.3) !important;
  }

}

/* pageRow */
.pageRow {

  :deep .el-pagination {
    .el-pagination__total {
      color: white;
    }

    .el-pagination__jump, .el-pagination__sizes {
      .el-pagination__goto {
        color: white;
      }

      .el-input__wrapper {
        background: transparent;
        border: none;
      }
    }

    .el-select {
      --el-select-input-focus-border-color: greenYellow;
    }

    .el-input {
      --el-input-focus-border: greenYellow;
      --el-input-focus-border-color: greenYellow;
    }

    .el-input__inner {
      color: white; //文字颜色
    }

    .el-pager li.is-active {
      color: greenyellow;
    }

    .btn-prev,
    .btn-next,
    .el-pager li,
    {
      background-color: transparent;
      color: white;
      border: none;
    }

    .el-pager li:hover,
    .btn-prev:hover,
    .btn-next:hover,
    {
      background-color: transparent;
      color: greenyellow;
      border: 1px solid white;
      font-weight: bold;
    }
  }
}

/* dialog */
.dialog :deep {
  --el-color-white: white;
  span {
    color: white;
  }

  .el-input-number {
    border: 1px solid white;
    border-radius: 5px;
    box-shadow: none;
  }

  .el-input-number__decrease {
    background: none;
  }

  .el-input-number__increase {
    background: none;
  }

  .el-input .el-input__wrapper.is-focus {
    border-bottom: 1px solid greenyellow;
  }

  .el-input .el-input__wrapper {
    background-color: rgba(255, 255, 255, 0);
    color: white;
    border-radius: 0;
    border-bottom: 1px solid white;
    box-shadow: 0 0;
  }

  .el-input .el-input__inner {
    color: white;
  }

  .el-slider {
    --el-slider-main-bg-color: rgba(255, 255, 255, 0.5);

    .el-input .el-input__wrapper {
      background: none;
      color: white;
      border: none;
    }
  }

  .el-slider__bar {
    background: rgba(204, 204, 204, 0.45);
  }

  .el-slider__runway {
    border: 1px solid transparent;
    background: rgba(204, 204, 204, 0.45);
  }

  .el-icon {
    color: white;
  }

  .el-dialog {
    background: #2b2b2b;
  }

  .el-upload-dragger {
    background: transparent;
  }

  .el-button {
    background: transparent;
    border: 1px solid white;

    .el-icon {
      color: white;
    }
  }

  .el-button:hover span {
    color: greenyellow;
  }

  .el-button:active {
    border: 1px solid greenyellow;
  }

  .el-upload-dragger:hover {
    border-color: yellowgreen;
  }
}

</style>