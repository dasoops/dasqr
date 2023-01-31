<template>
  <el-form-item :label="label" class="text-color">
    <el-switch
        v-model="value"
        class="mt-2"
        size="large"
        style="margin-left: 24px; --el-switch-on-color: black; --el-switch-off-color: black"
        inline-prompt
        :active-value="activeValue"
        :inactive-value="inactiveValue"
        :active-icon="Check"
        :inactive-icon="Close"
        @change="handleChange"
    />
  </el-form-item>
</template>

<script lang="ts">
export default {
  name: "dasSelect"
}
</script>

<script lang="ts" setup>
import {ref, watch} from "vue";
import {Check, Close} from "@element-plus/icons";

const {modelValue, label, activeValue, inactiveValue} = withDefaults(defineProps<{
  modelValue: boolean | number | string,
  label: string,
  activeValue?: number | string | boolean,
  inactiveValue?: number | string | boolean,
}>(), {
  activeValue: 1,
  inactiveValue: 0,
});

const emit = defineEmits(['update:modelValue']);

const value = ref();

watch(() => modelValue, modelValue => {
  value.value = modelValue
}, {immediate: true})

const handleChange = function (value: boolean | number | string) {
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