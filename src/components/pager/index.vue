<template>
  <el-row justify="end" class="pageRow">
    <el-pagination
        :current-page="current"
        :page-size="size"
        :page-sizes="[16, 32, 64, 128]"
        small
        background
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </el-row>
</template>

<script lang="ts">
export default {
  name: "dasPager"
}
</script>

<script lang="ts" setup>

const {current, size, total} = defineProps<{
  current: number,
  size: number,
  total: number,
}>();

const emit = defineEmits(['current-change', 'size-change']);

const handleCurrentChange = function (current: number) {
  emit('current-change', current)
}
const handleSizeChange = function (size: number) {
  emit('size-change', size)
}
</script>

<style lang="scss" scoped>
.pageRow {
  :deep(.el-pagination) {
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
      --el-select-input-focus-border-color: white
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
</style>