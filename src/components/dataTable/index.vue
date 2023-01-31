<template>
  <el-row class="tableRow" style="height: 100%">
    <el-table
        :v-loading="isLoading"
        element-loading-background="rgba(43, 43, 43, 0.6)"
        :data="value"
        height="100%"
        style="width: 100%"
        empty-text=""
        resizable
        stripe
    >
      <slot/>
      <el-table-column
          width="110"
      >
        <template v-slot="scope">
          <el-button
              color="#ffffff"
              size="small"
              plain
              @click="$emit('delete',scope.row)"
              :icon="Delete"
          />
          <el-button
              color="#ffffff"
              size="small"
              plain
              @click="$emit('edit',scope.row)"
              :icon="Edit"
          />
        </template>
      </el-table-column>
    </el-table>
  </el-row>
</template>

<script lang="ts">
export default {
  name: "dasDataTable"
}
</script>

<script lang="ts" setup>
import {ref, toRefs, watch} from "vue";
import {Delete, Edit} from '@element-plus/icons-vue'

let value = ref([]);
const props = defineProps<{
  modelValue: [],
  isLoading: boolean,
}>();

const emit = defineEmits(['delete', 'edit']);

const {modelValue, isLoading} = toRefs(props);

watch(modelValue,
    (modelValue) => {
      value.value = modelValue
    },
    {
      immediate: true, deep: true
    }
)

</script>

<style lang="scss" scoped>
.tableRow {

  :deep(.el-select) {
    .el-input .el-input__wrapper {
      background-color: rgba(255, 255, 255, 0);
      color: white;
      border-radius: 0;
      border-bottom: 1px solid white;
      box-shadow: 0 0;
    }

    .el-input .el-input__wrapper.is-focus {
      border-bottom: 1px solid greenyellow;
    }
  }

  .el-button {
    --el-button-active-border-color: greenYellow !important;
    --el-button-active-text-color: greenYellow !important;
    --el-button-disabled-border-color: grey !important;
    --el-button-disabled-text-color: grey !important;

    color: white;
    background-color: rgba(255, 255, 255, 0);

    .el-icon {
      color: white;
    }
  }

  .el-button:hover{
    color: greenyellow;
  }

  :deep(.el-table) {

    ::before {
      left: 0;
      bottom: 0;
      width: 100%;
      height: 0;
    }

    th, tr, td {
      color: white;
      background: transparent;
      border: none;
    }

    th, td {
      border-bottom: 1px solid #ffffff;
    }

    /* 底下的线 */
    .el-table__inner-wrapper::before {
      height: 0;
    }

    tbody tr:hover > td {
      background-color: rgba(243, 222, 194, 0.3) !important;
    }
  }

  /* 斑马纹 */
  :deep(.el-table--striped) {
    .el-table__body .el-table__row--striped td {
      background-color: rgba(255, 255, 255, 0.05)
    }
  }
}
</style>