<template>
  <el-header>
    <el-row :gutter="20">
      <el-col :span="20">
        <nav>
          <router-link to='/config'>Config</router-link>
          <span> | </span>
          <router-link to='/register'>Register</router-link>
          <span> | </span>
          <router-link to='/plugin'>Plugin</router-link>
          <span> | </span>
          <router-link to='/role'>Role</router-link>
          <span> | </span>
          <router-link to='/image'>Image</router-link>
        </nav>
      </el-col>
      <el-col :span="4">
        <nav id="loginNav">
          <a v-if="$store.state.isLogin" href="javascript:void(0)" class="router-link-active router-link-exact-active"
             @click="logout"> logOut</a>
          <router-link v-else to='/login'>Login</router-link>
        </nav>
      </el-col>
    </el-row>
  </el-header>
</template>

<script>
import {defineComponent, reactive, toRefs} from "vue";
import {useRouter} from "vue-router";
import {useStore} from "@/conf/store";

export default defineComponent({
  name: 'myHeader',
  setup() {
    const router = useRouter();
    let store = useStore();

    const resObj = reactive({
      isLogin: false,
      token: ''
    })

    const logout = function () {
      localStorage.removeItem("token");
      store.commit("refresh");
      router.push("/login");
    }

    return {...toRefs(resObj), logout};
  }
})
</script>

<style lang="scss" scoped>
.el-header {
  border-bottom: 1px solid white;
}

nav {
  padding: 30px;
  text-align: left;

  a {
    font-weight: bold;
    color: #42b983;

    &.router-link-exact-active {
      color: white;
    }
  }
}

#loginNav {
  text-align: right;

  a {
    font-weight: bold;
    color: #42b983;
  }
}
</style>