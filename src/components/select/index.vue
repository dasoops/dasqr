<template>
  <el-form-item :label="label" class="text-color">
    <el-select
        v-model="value"
        collapse-tags
        :multiple="multiple"
        :placeholder="placeHolder"
        style="width: 200px"
        @change="handleChange"
    >
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.show"
          :value="item.value"
      />
    </el-select>
  </el-form-item>
</template>

<script lang="ts">
export default {
  name: "dasSelect"
}
</script>

<script lang="ts" setup>
import {ref, watch} from "vue";
import {SelectOption} from "@/components/select/entity";

const {modelValue, options, label, placeHolder, multiple = false} = defineProps<{
  modelValue: string[] | number | string | boolean,
  label?: string,
  placeHolder?: string,
  options: SelectOption[],
  multiple?: boolean,
}>();

const emit = defineEmits(['update:modelValue']);

const value = ref();

watch(() => modelValue, modelValue => {
  value.value = modelValue
}, {immediate: true})

const handleChange = function (value: string) {
  emit('update:modelValue', value)
}
</script>

<style lang="scss" scoped>

:deep(.el-tag) {
  background: none;
  border: 1px solid white;
  color: white;

  .el-tag__close:hover {
    color: greenyellow;
    background: #2b2b2b;
  }
}


:deep(.el-select) {
  --el-select-input-focus-border-color: none;

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


</style>