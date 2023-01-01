<template>
  <das-header></das-header>
  <el-container>
    <el-main>
      <router-view/>
    </el-main>
  </el-container>
</template>

<script lang="ts">
import DasHeader from "@/components/dasHeader.vue";
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
  background-color: rgba(43, 43, 43, 100);
}

#app {
  font-family: "Consolas", "Microsoft YaHei", "Avenir", "Helvetica", "Arial", "sans-serif";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: white;
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
  background: #2b2b2b;
}

.el-select-dropdown__item {
  color: white;
}

.el-select-dropdown__item.hover, .el-select-dropdown__item:hover, .el-select-dropdown__item.selected {
  background: #363636FF;
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

.el-message-box{
  background: #2b2b2b;
  border: none;
  span,p{
    color: white;
  }
  .el-message-box__btns .el-button{
    background: transparent;
    border: 1px solid white;
  }
  .el-message-box__btns .el-button:hover{
    span{
      color: greenyellow;
    }
  }

}
</style>
