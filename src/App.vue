<template>
  <das-header></das-header>
  <el-container>
    <el-main>
      <router-view/>
    </el-main>
  </el-container>
</template>

<script lang="ts">
import DasHeader from "@/components/header/index.vue";
import {defineComponent} from "vue";

export default defineComponent({
  components: {DasHeader},
})

</script>

<style lang="scss">
* {
  padding: 0;
  margin: 0;
}

html, body, #app {
  width: 100%;
  height: 100%;
}

#app {
  --el-font-family: 'consolas', 'Microsoft YaHei', '微软雅黑', 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', Arial, sans-serif;
  font-family: var(--el-font-family);
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

html.dark {
  --el-color-primary: greenYellow;
  color: white;
  --el-color-info: white;
  --el-border-color: white;
  --el-button-hover-bg-color: #2b2b2b;
  --el-color-primary-light-3: #adff2f;
  --el-color-primary-light-5: #9fe72f;
  --el-color-primary-light-7: #ffffff;
  --el-color-primary-light-8: #ffffff;
  --el-color-primary-light-9: #2b2b2b;
  --el-color-primary-dark-2: #9fe72f;
  --el-text-color-disabled: #b1ff9c;
  --el-bg-color: #2b2b2b;
  background: #2b2b2b;
}


.el-form-item__label {
  color: white;
  font-size: 16px;
}

.el-container {
  height: calc(100% - 60px);
}

.el-select__popper.el-popper {
  border: 1px solid grey;
}

.el-scrollbar {
  //background: #2b2b2b;
}

.el-select-dropdown__item {
  color: white;
}

.el-select-dropdown__item.hover, .el-select-dropdown__item:hover, .el-select-dropdown__item.selected {
  background: #363636;
  color: greenyellow;
}

.el-message--error {
  --el-message-bg-color: #2b2b2b;
  --el-message-border-color: #ff9c9c;
  --el-message-text-color: white;
}

.el-message--success {
  --el-message-bg-color: #2b2b2b;
  --el-message-border-color: #ccffae;
  --el-message-text-color: white;
}

.el-message-box {
  background: #2b2b2b;
  border: none;

  span, p {
    color: white;
  }

  .el-message-box__btns .el-button {
    background: transparent;
    border: 1px solid white;
  }

  .el-message-box__btns .el-button:hover {
    span {
      color: greenyellow;
    }
  }

}

.el-autocomplete-suggestion li {
  background: #2b2b2b;
  color: white;
}

.el-autocomplete-suggestion li:hover {
  background: #363636;
  color: greenyellow;
}

.el-popper.is-light {
  background: #2b2b2b;
  color: white;

  .el-tag {
    --el-tag-text-color: white;
    background: none;
    border: 1px solid white;
    border-radius: 5px;
  }
}

.el-select__popper.el-popper {
  //background: none;
  //border: 1px solid white;
}

.el-select-dropdown.is-multiple .el-select-dropdown__item.selected.hover {
  background-color: #363636;
  color: greenyellow;
}

.el-select-dropdown.is-multiple .el-select-dropdown__item.hover {
  background-color: #363636;
  color: white;
}

.el-select-dropdown.is-multiple .el-select-dropdown__item.selected {
  color: greenyellow;
}

.el-select-dropdown.is-multiple .el-select-dropdown__item.selected::after {
  background-color: greenyellow;
}


</style>
