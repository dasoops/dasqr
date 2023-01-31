<template>
  <el-header>
    <el-menu
        class="el-menu-route"
        mode="horizontal"
        background-color="transparent"
        text-color="white"
        :ellipsis="false"
        :default-active="router.currentRoute.value.path"
        active-text-color="greenYellow"
        :router="true"
    >
      <template v-for="(route,index) in routes" :key="index">
        <el-sub-menu class="el-sub-menu-route" v-if="route.meta.isMenuRoute" :index="index.toString()">
          <template #title>{{ route.name }}</template>
          <template v-for="childrenRoute in route.children">
            <el-menu-item v-if="childrenRoute.meta.show" :key="childrenRoute.path"
                          :index="route.path + '/' + childrenRoute.path">
              {{ childrenRoute.name }}
            </el-menu-item>
          </template>
        </el-sub-menu>
      </template>
      <div class="flex-grow"/>
      <el-menu-item class="el-sub-menu-route el-menu-item-route" v-if="store.state.token" index="login" key="logout"
                    @click="logout">
        logout
      </el-menu-item>
      <el-menu-item class="el-sub-menu-route el-menu-item-route" v-else index="login" key="login">
        login
      </el-menu-item>
    </el-menu>
  </el-header>
</template>

<script lang="ts" setup>
import {getStore} from "@/conf/store";
import router from "@/conf/router";

const name = "dasDrag";
let routes = router.options.routes;
let store = getStore();

const logout = function () {
  localStorage.removeItem("token");
  store.commit("refresh");

  router.push("/login");
};

</script>

<script lang="ts">
export default {
  name: 'dasHeader',
}
</script>

<style lang="scss" scoped>
.el-header {
  padding: 0;
}

:deep .el-menu-route {
  padding-left: 50px;
  padding-right: 50px;

  .el-sub-menu__title {
    font-size: 16px;
    font-weight: bold;
    text-decoration: underline;
  }
}

.el-menu-item-route {
  font-size: 16px;
  font-weight: bold;
  text-decoration: underline;
}

:deep .el-menu--horizontal > .el-sub-menu .el-sub-menu__title:hover {
  background: #363636 !important;
  color: greenyellow !important;
}

.el-menu {
  border-bottom: 2px solid #b3b3b3 !important;
}

.el-menu--horizontal .el-menu-item:not(.is-disabled):focus,
.el-menu--horizontal .el-menu-item:not(.is-disabled):hover {
  color: greenyellow;
  background: #363636;
}

.el-menu--horizontal {
  border-bottom: none;
}

.flex-grow {
  flex-grow: 1;
}
</style>