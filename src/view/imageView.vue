<template>
  <div style="height: 5%">
    <el-form :model="getImageInfoPageParam" class="searchForm" @keydown.enter="loadData">
      <el-row :gutter="35">
        <el-col :offset="1" :span="6">
          <el-form-item label="keyword like" class="text-color">
            <el-input v-model="getImageInfoPageParam.keyword" placeholder="% enter %" class="input-line" clearable/>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="createUser">
            <el-autocomplete
                v-model="fantastyUserKeyword"
                :fetch-suggestions="queryFantastyUser"
                placeholder="% enter %"
                @select="handleSelectFantastyUser"
                @change="handleSelectFantastyUser"
                class="input-line"
                value-key="author"
                :hide-loading="true"
                clearable
                :fit-input-width="true"
                width="100%"
            />
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
            width="280">
        </el-table-column>
        <el-table-column
            prop="author"
            label="author"
            width="320"
        >
        </el-table-column>
        <el-table-column
            prop="updateTime"
            label="updateTime"
        >
        </el-table-column>
        <el-table-column
            width="160"
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
            <el-popover placement="left" width="auto" trigger="hover" effect="dark">
              <template #reference>
                <el-button
                    color="#ffffff"
                    size="small"
                    plain
                    :icon="View"
                />
              </template>
              <el-image style="max-height: 600px;max-width: 600px" :src="getViewPath(scope.row)" fit="scale-down"/>
            </el-popover>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
  </div>
  <div style="height: 2%"/>
  <div style="height: 5%">
    <el-row justify="end" class="pageRow">
      <el-pagination
          v-model:current-page="getImageInfoPageParam.current"
          v-model:page-size="getImageInfoPageParam.size"
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
      <el-form :model="editImageInfoParam" class="searchForm" label-position="top" @keydown.enter="handleEdit">
        <el-form-item label="keyword" class="text-color">
          <el-input v-model="editImageInfoParam.keyword" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-upload
            :drag="true"
            list-type="picture"
            class="avatar-uploader"
            accept=".jpeg,.png,.jpg,.bmp,.gif"
            :action="uploadImageUrl"
            :method="uploadImageMethod"
            :headers="requestHeaders"
            :show-file-list="false"
            :on-success="handleEditUploadSuccess"
            :before-upload="checkFileType"
        >
          <el-image style="max-height: 100%;max-width: 100%" :src="editImageShowFilePath" fit="scale-down"/>
        </el-upload>
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
        :title="addTitle"
        width="30%"
        align-center
        draggable
    >
      <el-form :model="addImageParam" class="searchForm" label-position="top" @keydown.enter="handleAdd">
        <el-form-item label="keyword" class="text-color">
          <el-input v-model="addImageParam.keyword" placeholder="" class="input-line" clearable/>
        </el-form-item>
        <el-form-item>
          <el-upload
              :drag="true"
              list-type="picture"
              class="avatar-uploader"
              accept=".jpeg,.png,.jpg,.bmp,.gif"
              :action="uploadImageUrl"
              :method="uploadImageMethod"
              :headers="requestHeaders"
              :show-file-list="false"
              :on-success="handleAddUploadSuccess"
              :before-upload="checkFileType"
              multiple
              style="width: 100%"
          >
            <el-image style="max-height: 100%;max-width: 100%" v-if="addImageShowFilePath" :src="addImageShowFilePath"
                      fit="scale-down"/>
            <div v-else>
              <el-icon :size="40" color="#FFFFFF">
                <Upload-filled/>
              </el-icon>
              <div class="el-upload__text" style="color: white">
                Drop file here or <em style="color: yellowgreen">click to upload</em>
              </div>
            </div>
          </el-upload>
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
import {UploadFilled, Check, Close, Delete, Download, Edit, Plus, Search, View} from '@element-plus/icons-vue'
import {ElMessage, ElMessageBox} from "element-plus";
import {
  AddImageParam, DeleteImageParam,
  EditImageInfoParam, FantastyUserRes,
  GetImageInfoPageParam,
  ImageData, UploadImageRes
} from "@/entity/param/imageParam";
import {
  addImage,
  deleteImage,
  editImageInfo,
  exportAllImageInfo,
  getImageInfoPage, getNextImageId,
  uploadImageMethod,
  uploadImageUrl
} from "@/request/imageRequest";
import {UploadRawFile} from "element-plus/lib/components";
import {AxiosHeaders} from "axios";
import {Result} from "@/entity/result/BaseResult";
import { simpleExport } from "@/util/DownloadUtil";
import {GetFantastyUserParam} from "@/entity/param/registerParam";
import {getFantasyUser} from "@/request/registerRequest";

export default defineComponent({
  setup() {
    let tableData: Array<ImageData> = reactive([]);
    const getImageInfoPageParam: GetImageInfoPageParam = reactive({
      size: 32,
      current: 1
    });
    const editImageInfoParam: EditImageInfoParam = reactive({
      rowId: 0,
      fileName: '',
      keyword: '',
    });
    const addImageParam: AddImageParam = reactive({
      keyword: '',
      fileName: ''
    })
    let total = 0;
    let showEditDialog = false;
    let showAddDialog = false;
    let loading = false;
    let addTitle = '';
    let fantastyUserList: string[] = [];
    let viewImagePath = '';
    let fantastyUserKeyword = '';
    let editImageShowFilePath = '';
    let addImageShowFilePath = '';
    const requestHeaders = new AxiosHeaders({"Authorization": localStorage.getItem("token")})

    const loadData = async function () {
      dataMap.loading = true;
      getImageInfoPage(getImageInfoPageParam).then(res => {
        dataMap.tableData = reactive(res.data);
        dataMap.tableData.forEach(rowData => {
          rowData.author = "(" + rowData.authorId + ") " + rowData.authorName;
        })
        dataMap.total = res.total;
        dataMap.loading = false;
      })
    }
    const handleEdit = function () {
      editImageInfo(dataMap.editImageInfoParam).then(() => {
        dataMap.showEditDialog = false;
        loadData();
      })
    }
    const handleAdd = function () {
      addImage(dataMap.addImageParam).then(() => {
        dataMap.showAddDialog = false;
        loadData();
      })
    }
    const handleEditUploadSuccess = function (res: Result<UploadImageRes>) {
      let data = res.data;
      dataMap.editImageShowFilePath = data.filePath;
      dataMap.editImageInfoParam.fileName = data.fileName;
    }
    const handleAddUploadSuccess = function (res: Result<UploadImageRes>) {
      let data = res.data;
      dataMap.addImageShowFilePath = data.filePath;
      dataMap.addImageParam.fileName = data.fileName;
    }
    const handleCurrentChange = function (current: number) {
      dataMap.getImageInfoPageParam.current = current;
      loadData();
    }
    const handleSizeChange = function (size: number) {
      dataMap.getImageInfoPageParam.size = size;
      loadData();
    }
    const handleSelectFantastyUser = function (res: FantastyUserRes) {
      dataMap.getImageInfoPageParam.createUser = res.registerId;
    }
    const handleExport = function () {
      exportAllImageInfo().then(res => {
        simpleExport(res);
      })

    }
    const queryFantastyUser = async function () {
      const matchRexStr = /\([1-9][0-9]{4,}\)[\w]*\s/g;
      let userEnterKeyword = dataMap.fantastyUserKeyword;
      if (matchRexStr.test(userEnterKeyword)) {
        await getFantasyUser(new class implements GetFantastyUserParam {
          keyword = dataMap.getImageInfoPageParam.createUser ? dataMap.getImageInfoPageParam.createUser.toString() : "";
        }).then(function (res) {
          for (let fantastyUserListElement of res.data.fantastyUserList) {
            fantastyUserListElement.author = "(" + fantastyUserListElement.registerId + ") " + fantastyUserListElement.name;
          }
          dataMap.fantastyUserList = res.data.fantastyUserList;
        })
      } else {
        await getFantasyUser(new class implements GetFantastyUserParam {
          keyword = dataMap.fantastyUserKeyword;
        }).then(function (res) {
          for (let fantastyUserListElement of res.data.fantastyUserList) {
            fantastyUserListElement.author = "(" + fantastyUserListElement.registerId + ") " + fantastyUserListElement.name;
          }
          dataMap.fantastyUserList = res.data.fantastyUserList;
        })
      }
      return dataMap.fantastyUserList;
    }
    const toEdit = function (rowData: ImageData) {
      dataMap.editImageInfoParam.rowId = rowData.rowId;
      dataMap.editImageInfoParam.keyword = rowData.keyword;
      dataMap.editImageShowFilePath = rowData.filePath;
      dataMap.editImageInfoParam.fileName = rowData.fileName;
      dataMap.showEditDialog = true;
    }
    const toAdd = function () {
      getNextImageId().then(res => {
        dataMap.addTitle = 'Add ( ' + res.data.rowId + ' )';
      })
      dataMap.addImageParam.keyword = '';
      dataMap.addImageParam.fileName = '';
      dataMap.addImageShowFilePath = '';
      dataMap.showAddDialog = true;
    }
    const getViewPath = function (rowData: ImageData) {
      return rowData.filePath;
    }
    const getEditTitle = function () {
      return "Edit (" + dataMap.editImageInfoParam.rowId + ":" + dataMap.editImageInfoParam.keyword + ")";
    }
    const init = function () {
      loadData();
    }
    const checkFileType = function (file: UploadRawFile) {
      const fileName = file.name;
      const fileType = fileName.substring(fileName.lastIndexOf('.'));
      if (
          fileType != '.jpg' &&
          fileType != '.png' &&
          fileType != '.jpeg' &&
          fileType != '.bmp' &&
          fileType != '.gif'
      ) {
        ElMessage.error('不是,jpeg,.png,.jpg,.bmp,.gif文件,请上传正确的图片类型');
        return false;
      }
    }
    const toDelete = function (rowData: ImageData) {
      ElMessageBox.confirm(
          'You could lose him for index.vue long time. Continue?',
          'Warning',
          {
            confirmButtonText: 'OK',
            cancelButtonText: 'Cancel',
            type: 'warning',
          }
      ).then(function () {
        deleteImage(new class implements DeleteImageParam {
          rowId = rowData.rowId;
        }).then(() => {
          loadData();
        })
      })
    }
    const dataMap = reactive({
      tableData,
      getImageInfoPageParam,
      total,
      showEditDialog,
      showAddDialog,
      loading,
      addImageShowFilePath,
      fantastyUserKeyword,
      fantastyUserList,
      editImageInfoParam,
      editImageShowFilePath,
      addImageParam,
      viewImagePath,
      addTitle,
      uploadImageUrl,
      uploadImageMethod,
      requestHeaders,
    })
    const functionMap = {
      handleCurrentChange,
      handleSizeChange,
      queryFantastyUser,
      getViewPath,
      handleExport,
      handleEditUploadSuccess,
      handleAddUploadSuccess,
      handleSelectFantastyUser,
      checkFileType,
      toEdit,
      getEditTitle,
      loadData,
      handleEdit,
      handleAdd,
      toDelete,
      toAdd,
    }

    init();

    return {...toRefs(dataMap), ...functionMap, UploadFilled, View, Download, Search, Plus, Edit, Delete, Close, Check};
  }
})
</script>

<style lang="scss" scoped>
/* searchForm */
.searchForm {

  :deep .el-autocomplete {
    width: 100%;
  }

  :deep .el-input .el-input__wrapper.is-focus {
    border-bottom: 1px solid greenyellow;
  }

  :deep .el-input .el-input__wrapper {
    background-color: rgba(255, 255, 255, 0);
    color: white;
    border-radius: 0;
    border-bottom: 1px solid white;
    box-shadow: 0 0;
  }

  :deep .el-input .el-input__inner {
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
  span {
    color: white;
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