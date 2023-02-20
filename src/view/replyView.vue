<template>
  <!-- search  -->
  <div id="search" style="height: 5%" class="search">
    <el-row :gutter="35" @keydown.enter="loadData">
      <el-col :offset="1" :span="6">
        <das-input v-model="searchDataMap.param.matchKeyword" placeHolder="%keyword%" label="keyword like"/>
      </el-col>
      <el-col :span="4">
        <das-select v-model="searchDataMap.param.matchTypeList" :options="options" label="matchType" :multiple="true"/>
      </el-col>
      <el-col :span="10">
      </el-col>
      <el-col :span="3">
        <el-row :gutter="15">
          <el-col :span="5">
            <el-button :icon="Search" @click="loadData" circle/>
          </el-col>
          <el-col :span="5">
            <el-button :icon="Plus" @click="toAdd" circle/>
          </el-col>
          <el-col :span="5">
            <el-button :icon="Download" @click="handleExport" circle/>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
  <!-- table -->
  <div id="table" style="height: 88%">
    <das-data-table v-model="searchDataMap.tableData" :is-loading="searchDataMap.isLoading" @edit="toEdit"
                    @delete="toDelete">
      <el-table-column label="id" prop="rowId" min-width="3%" header-align="center" align="center"/>
      <el-table-column label="keyword" prop="keyword" min-width="17%"/>
      <el-table-column label="reply" prop="reply" min-width="18%"/>
      <el-table-column label="matchType" prop="matchTypeShow" min-width="8%" header-align="center" align="center"/>
      <el-table-column label="enable" prop="enableShow" min-width="8%" header-align="center" align="center"/>
      <el-table-column label="ignoreCase" prop="ignoreCaseShow" min-width="8%" header-align="center" align="center"/>
      <el-table-column label="ignoreDbc" prop="ignoreDbcShow" min-width="8%" header-align="center" align="center"/>
      <el-table-column label="" prop="" min-width="30%"/>
    </das-data-table>
  </div>
  <!--  pager  -->
  <div id="pager">
    <das-pager :total="searchDataMap.total" :current="searchDataMap.param.current" :size="searchDataMap.param.size"
               @current-change="handleCurrentChange" @size-change="handleSizeChange"/>
  </div>
  <!-- dialog-edit  -->
  <div id="dialog-edit">
    <das-dialog v-model="editDataMap.show" :title="editDataMap.title" @submit="handleEdit">
      <el-form
          :model="editDataMap.param"
          label-position="top"
          @keydown.enter="handleEdit"
          :rules="globalRule"
      >
        <das-input v-model="editDataMap.param.keyword" prop="keyword" label="keyword"/>
        <das-input v-model="editDataMap.param.reply" prop="reply" label="reply"/>
        <el-row>
          <el-col :span="9">
            <das-select v-model="editDataMap.param.matchType" :options="options" label="matchType" :multiple="false"/>
          </el-col>
          <el-col :span="4">
            <das-switch v-model="editDataMap.param.enable" label="enable"/>
          </el-col>
          <el-col :span="4">
            <das-switch v-model="editDataMap.param.ignoreDbc" label="ignoreDbc"/>
          </el-col>
          <el-col :span="5">
            <das-switch v-model="editDataMap.param.ignoreCase" label="ignoreCase"/>
          </el-col>
        </el-row>
      </el-form>
    </das-dialog>
  </div>
  <!-- dialog-add  -->
  <div id="dialog-add">
    <das-dialog v-model="addDataMap.show" :title="addDataMap.title" @submit="handleAdd">
      <el-form
          :model="addDataMap.param"
          label-position="top"
          @keydown.enter="handleAdd"
          :rules="globalRule"
      >
        <das-input v-model="addDataMap.param.keyword" prop="keyword" label="keyword"/>
        <das-input v-model="addDataMap.param.reply" prop="reply" label="reply"/>
        <el-row>
          <el-col :span="9">
            <das-select v-model="addDataMap.param.matchType" :options="options" label="matchType" :multiple="false"/>
          </el-col>
          <el-col :span="4">
            <das-switch v-model="addDataMap.param.enable" label="enable"/>
          </el-col>
          <el-col :span="4">
            <das-switch v-model="addDataMap.param.ignoreDbc" label="ignoreDbc"/>
          </el-col>
          <el-col :span="5">
            <das-switch v-model="addDataMap.param.ignoreCase" label="ignoreCase"/>
          </el-col>
        </el-row>
      </el-form>
    </das-dialog>
  </div>
</template>

<script lang="ts" setup>
import {reactive, Ref, ref} from "vue";
import {Download, Plus, Search, Check, Close} from '@element-plus/icons-vue'
import DasInput from "@/components/input/index.vue";
import DasSelect from "@/components/select/index.vue";
import DasDataTable from "@/components/dataTable/index.vue"
import DasSwitch from "@/components/switch/index.vue"
import {AddReplyParam, EditReplyParam, GetReplyPageParam} from "@/entity/param/replyParam";
import {addReply, deleteReply, editReply, exportAllReply, getNextReplyId, getReplyPage} from "@/request/replyRequest";
import {SelectOption} from "@/components/select/entity";
import {ReplyTableShowDto} from "@/entity/dto/replyDto";
import {ElMessageBox, FormInstance, FormRules} from "element-plus";
import DasDialog from "@/components/dialog/index.vue";
import {DeleteParam} from "@/entity/param/BaseParam";
import {simpleExport} from "@/util/DownloadUtil";
import DasPager from "@/components/pager/index.vue";

//global begin
const options: SelectOption[] = [{
  show: 'all',
  value: 0,
}, {
  show: 'prefix',
  value: 1,
}, {
  show: 'suffix',
  value: 2,
}, {
  show: 'contain',
  value: 3,
}]
const globalRule = reactive<FormRules>({
  keyword: [
    {
      required: true,
      message: 'keyword is null',
      trigger: 'blur'
    },
  ],
  reply: [
    {
      required: true,
      message: 'reply is null',
      trigger: 'blur'
    }
  ],
});

//search begin
const searchDataMap: { isLoading: boolean, tableData: ReplyTableShowDto[], total: number, param: GetReplyPageParam } = reactive({
  isLoading: false,
  tableData: [],
  total: 16,
  param: {
    current: 1,
    size: 32,
  },
})
const loadData = function () {
  searchDataMap.isLoading = true;
  getReplyPage(searchDataMap.param).then(res => {
    searchDataMap.tableData = res.data.map(vo => {
      let matchTypeShow: string;
      switch (vo.matchType) {
        case 0:
          matchTypeShow = 'all';
          break;
        case 1:
          matchTypeShow = 'prefix';
          break;
        case 2:
          matchTypeShow = 'suffix';
          break;
        case 3:
          matchTypeShow = 'contain';
          break;
      }
      return new class implements ReplyTableShowDto {
        rowId = vo.rowId;
        enable = vo.enable;
        enableShow = vo.enable === 1 ? 'true' : 'false';
        ignoreCaseShow = vo.ignoreCase === 1 ? 'true' : 'false';
        ignoreDbcShow = vo.ignoreDbc === 1 ? 'true' : 'false';
        ignoreCase = vo.ignoreCase;
        ignoreDbc = vo.ignoreDbc;
        keyword = vo.keyword;
        matchType = vo.matchType;
        reply = vo.reply;
        matchTypeShow = matchTypeShow;
      }
    })
    searchDataMap.total = res.total;
    searchDataMap.isLoading = false;
  })
}
const handleCurrentChange = function (current: number) {
  searchDataMap.param.current = current;
  loadData();
}
const handleSizeChange = function (size: number) {
  console.log(size);
  searchDataMap.param.size = size;
  loadData();
}

//edit begin
const editDataMap: { show: boolean, param?: EditReplyParam, title: string } = reactive({
  show: false,
  title: '',
  param: undefined,
})
const toEdit = function (row: ReplyTableShowDto) {
  editDataMap.show = true;
  editDataMap.param = new class implements EditReplyParam {
    rowId = row.rowId;
    enable = row.enable;
    ignoreCase = row.ignoreCase;
    ignoreDbc = row.ignoreDbc;
    keyword = row.keyword;
    matchType = row.matchType;
    reply = row.reply;
  }
  editDataMap.title = 'Edit (' + editDataMap.param.rowId + ': ' + editDataMap.param.keyword + ')'
}
const handleEdit = function () {
  editDataMap.param ? editReply(editDataMap.param).then(() => editDataMap.show = false) : undefined;
  loadData();
}

//delete begin
const toDelete = function (rowData: ReplyTableShowDto) {
  ElMessageBox.confirm(
      'You could lose him for long time. Continue?',
      'Warning',
      {
        confirmButtonText: 'OK',
        cancelButtonText: 'Cancel',
        type: 'warning',
      }
  ).then(function () {
    deleteReply(new class implements DeleteParam {
      rowId = rowData.rowId;
    }).then(() => {
      loadData();
    })
  })
}

//add begin
const addDataMap: { show: boolean, param?: AddReplyParam, title: string } = reactive({
  show: false,
  title: '',
  param: undefined,
})
const toAdd = async function () {
  await getNextReplyId().then(res => addDataMap.title = 'Edit (' + res.data.rowId + ')')
  addDataMap.show = true;
  addDataMap.param = new class implements AddReplyParam {
    enable = 1;
    ignoreCase = 1;
    ignoreDbc = 1;
    matchType = 0;
    keyword = '';
    reply = '';
  }
}
const handleAdd = async function () {
  addDataMap.param ? await addReply(addDataMap.param).then(() => addDataMap.show = false) : undefined;
  loadData();
}

//export begin
const handleExport = function () {
  exportAllReply().then(res => {
    simpleExport(res);
  })
}

//init begin
loadData();
//end
</script>

<style lang="scss" scoped>
.search {
  .el-button {
    color: white;
    background-color: rgba(255, 255, 255, 0);

    .el-icon {
      color: white;
    }
  }

  .el-button:hover {
    color: greenyellow;
  }

  .el-button:active {
    border: 1px solid greenyellow;
  }
}

.tableRow {
  padding: 10px
}

</style>