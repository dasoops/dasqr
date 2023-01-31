<template>
  <div class="dialog">
    <el-dialog
        :append-to-body="true"
        :model-value="modelValue"
        :title="title"
        width="30%"
        align-center
        draggable
        :destroy-on-close="true"
        @close="handleClose"
    >
      <slot/>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="handleClose">Cancel</el-button>
          <el-button @click="$emit('submit')">
            Confirm
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts">
export default {
  name: "dasDialog"
}
</script>

<script lang="ts" setup>
import {ref, watch} from "vue";
import {FormInstance, FormRules} from "element-plus";

const {title, modelValue} = defineProps<{
  title: string,
  modelValue: boolean,
}>();

const emit = defineEmits(['update:modelValue']);

const handleClose = function () {
  emit('update:modelValue', false)
}

</script>

<style lang="scss" scoped>
.dialog-footer {
  .el-button {
    color: white;

    :hover {
      color: greenyellow;
    }
  }
}

</style>