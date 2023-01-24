<template>
  <div style="height: 5%">
    <el-form :model="getConfigParam" class="searchForm" @keydown.enter="loadData">
      <el-row :gutter="35">
        <el-col :offset="1" :span="6">
          <el-form-item label="keyword like" class="text-color">
            <el-input v-model="getConfigParam.keyword" placeholder="% enter %" class="input-line" clearable/>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="description like">
            <el-input v-model="getConfigParam.description" placeholder="% enter %" class="input-line" clearable/>
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
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
  <div style="height: 88%">
    <el-row class="tableRow" style="height: 100%">
      <el-table
          v-loading="loading"
          element-loading-background="rgba(43, 43, 43, 0.6)"
          :data="tableData"
          height="100%"
          style="width: 100%"
          empty-text=""
          resizable
          stripe
      >
        <el-table-column
            prop="rowId"
            label="id"
            width="50"
            header-align="center"
            align="center"
        >
        </el-table-column>
        <el-table-column
            prop="keyword"
            label="keyword"
            width="220">
        </el-table-column>
        <el-table-column
            prop="value"
            label="value"
            width="260">
        </el-table-column>
        <el-table-column
            prop="description"
            label="description"
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
                :disabled="scope.row.canEdit === 0"
                :icon="Delete"
            />
            <el-button
                color="#ffffff"
                size="small"
                plain
                @click="toEdit(scope.row)"
                :disabled="scope.row.canEdit === 0"
                :icon="Edit"
            />
          </template>
        </el-table-column>
      </el-table>
    </el-row>
  </div>
  <div style="height: 2%"/>
  <div style="height: 5%">
    <el-row justify="end" class="pageRow">
      <el-pagination
          v-model:current-page="getConfigParam.current"
          v-model:page-size="getConfigParam.size"
          :page-sizes="[16, 32, 64, 128]"
          small
          background
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </el-row>
  </div>

  <div class="dialog">
    <el-dialog
        v-model="showEditDialog"
        :title="getEditTitle()"
        width="30%"
        align-center
        draggable
    >
      <el-form :model="editConfigParam" class="searchForm" label-position="top" @keydown.enter="handleEdit">
        <el-form-item label="keyword" class="text-color">
          <el-input v-model="editConfigParam.keyword" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="vulue" class="text-color">
          <el-input v-model="editConfigParam.value" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="description">
          <el-input v-model="editConfigParam.description" placeholder="" class="input-line" clearable/>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="showEditDialog = false">Cancel</el-button>
        <el-button @click="handleEdit">
          Confirm
        </el-button>
      </span>
      </template>
    </el-dialog>
    <el-dialog
        v-model="showAddDialog"
        :title="AddTitle"
        width="30%"
        align-center
        draggable
    >
      <el-form :model="addConfigParam" class="searchForm" label-position="top" @keydown.enter="handleAdd">
        <el-form-item label="keyword" class="text-color">
          <el-input v-model="addConfigParam.keyword" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="vulue" class="text-color">
          <el-input v-model="addConfigParam.value" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="description">
          <el-input v-model="addConfigParam.description" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item label="canEdit" label-postion="left">
          <el-switch
              v-model="addConfigParam.canEdit"
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
        <el-button @click="showAddDialog = false">Cancel</el-button>
        <el-button @click="handleAdd">
          Confirm
        </el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>


<script lang="ts">
import {defineComponent, reactive, toRefs} from "vue";
import {
  AddConfigParam,
  ConfigData,
  DeleteConfigParam,
  EditConfigParam,
  GetConfigPageParam
} from "@/entity/param/ConfigParam";
import {Check, Close, Delete, Download, Edit, Plus, Search} from '@element-plus/icons-vue'
import {
  addConfig,
  deleteConfig,
  editConfig,
  exportAllConfig,
  getConfigPage,
  getNextConfigId
} from "@/request/configRequest";
import {ElMessageBox} from "element-plus";
import { simpleExport } from "@/util/DownloadUtil";

export default defineComponent({
  setup() {
    let tableData: Array<ConfigData> = reactive([]);
    const getConfigParam: GetConfigPageParam = reactive({
      keyword: undefined,
      description: undefined,
      size: 32,
      current: 1
    });
    const editConfigParam: EditConfigParam = reactive({
      rowId: 0,
      keyword: '',
      value: '',
      description: ''
    });
    const addConfigParam: AddConfigParam = reactive({
      keyword: '',
      value: '',
      description: '',
      canEdit: 1,
    })
    let total = 0;
    let showEditDialog = false;
    let showAddDialog = false;
    let loading = false;
    let AddTitle = '';

    const loadData = async function () {
      dataMap.loading = true;
      getConfigPage(getConfigParam).then(res => {
        dataMap.tableData = reactive(res.data);
        dataMap.total = res.total;
        dataMap.loading = false;
      })
    }
    const handleEdit = function () {
      editConfig(dataMap.editConfigParam).then(() => {
        dataMap.showEditDialog = false;
        loadData();
      })
    }
    const handleAdd = function () {
      addConfig(dataMap.addConfigParam).then(() => {
        dataMap.showAddDialog = false;
        loadData();
      })
    }
    const handleCurrentChange = function (current: number) {
      dataMap.getConfigParam.current = current;
      loadData();
    }
    const handleSizeChange = function (size: number) {
      dataMap.getConfigParam.size = size;
      loadData();
    }
    const toEdit = function (rowData: ConfigData) {
      dataMap.editConfigParam.rowId = rowData.rowId;
      dataMap.editConfigParam.keyword = rowData.keyword;
      dataMap.editConfigParam.value = rowData.value;
      dataMap.editConfigParam.description = rowData.description;
      dataMap.showEditDialog = true;
    }
    const toAdd = function () {
      loadAddTitle();
      dataMap.addConfigParam.keyword = '';
      dataMap.addConfigParam.value = '';
      dataMap.addConfigParam.canEdit = 1;
      dataMap.addConfigParam.description = '';
      dataMap.showAddDialog = true;
    }
    const loadAddTitle = function () {
      getNextConfigId().then(res => {
        dataMap.AddTitle = 'Add ( ' + res.data.rowId + ' )';
      })
    }
    const getEditTitle = function () {
      return "Edit (" + dataMap.editConfigParam.rowId + ":" + dataMap.editConfigParam.keyword + ")";
    }
    const init = function () {
      loadData();
    }
    const toDelete = function (rowData: ConfigData) {
      ElMessageBox.confirm(
          'You could lose him for dasDrag.vue long time. Continue?',
          'Warning',
          {
            confirmButtonText: 'OK',
            cancelButtonText: 'Cancel',
            type: 'warning',
          }
      ).then(function () {
        deleteConfig(new class implements DeleteConfigParam {
          rowId = rowData.rowId
        }).then(() => {
          loadData();
        })
      })
    }
    const handleExport = function () {
      exportAllConfig().then(res => {
        simpleExport(res);
      })

    }

    const dataMap = reactive({
      tableData,
      getConfigParam,
      total,
      showEditDialog,
      showAddDialog,
      loading,
      editConfigParam,
      addConfigParam,
      AddTitle
    })
    const functionMap = {
      handleCurrentChange,
      handleSizeChange,
      toEdit,
      getEditTitle,
      loadAddTitle,
      loadData,
      handleEdit,
      handleAdd,
      toDelete,
      toAdd,
      handleExport,
    }

    init();

    return {...toRefs(dataMap), ...functionMap, Download, Search, Plus, Edit, Delete, Close, Check};
  }
})
</script>

<style lang="scss" scoped>
/* searchForm */
.searchForm {

  .el-input :deep .el-input__wrapper.is-focus {
    border-bottom: 1px solid greenyellow;
  }

  .el-input :deep .el-input__wrapper {
    background-color: rgba(255, 255, 255, 0);
    color: white;
    border-radius: 0;
    border-bottom: 1px solid white;
    box-shadow: 0 0;
  }

  .el-input :deep .el-input__inner {
    color: white;
  }

  .el-button {
    background-color: rgba(255, 255, 255, 0);

    :deep .el-icon {
      color: white;
    }
  }

  :deep .el-button:hover {
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

    .el-pager li.is-active {
      color: greenyellow;
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
  span {
    color: white;
  }

  .el-dialog {
    --el-color-white: white;
    background: #2b2b2b;
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
}
</style>