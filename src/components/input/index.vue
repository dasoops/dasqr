<template>
  <el-form-item :label="label" :prop="prop" class="text-color">
    <el-input v-model="value" :placeholder="placeHolder" @input="handleChange" class="input-line" clearable/>
  </el-form-item>
</template>

<script lang="ts">
export default {
  name: "dasInput"
}
</script>

<script lang="ts" setup>
import {ref, watch} from "vue";

const {modelValue, label, placeHolder, prop} = defineProps<{
  modelValue: string,
  label?: string,
  placeHolder?: string,
  prop?: string,
}>();

const emit = defineEmits(['update:modelValue']);

const value = ref('');

watch(() => modelValue, modelValue => {
  value.value = modelValue
}, {immediate: true})

const handleChange = function (value: string) {
  emit('update:modelValue', value)
}
</script>

<style lang="scss" scoped>

.el-input .el-input__wrapper.is-focus {
  border-bottom: 1px solid greenyellow;
}

.el-input {
  background: transparent;

  :deep(.el-input__wrapper) {
    background-color: rgba(220, 214, 214, 0);
    color: white;
    border-radius: 0;
    border-bottom: 1px solid white;
    box-shadow: 0 0;

  }

  :deep(.is-focus) {
    border-bottom: 1px solid greenyellow;
  }

  :deep(.el-input__inner) {
    color: white;
  }
}
</style>