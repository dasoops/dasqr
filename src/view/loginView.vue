<template>
  <div class="login-box">
    <el-form
        ref="loginFormRef"
        :model="formData"
        status-icon
        :rules="rules"
        class="login-form"
        label-width="80px"
        @keydown.enter="loginFunc(loginFormRef)"
    >
      <h2>
        Login
      </h2>
      <el-form-item label="用户名" prop="username">
        <el-input v-model.number="formData.username"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="formData.password" type="password" autocomplete="off"/>
      </el-form-item>
      <el-button class="loginBtn" type="primary" @click="loginFunc(loginFormRef)"
      >登录
      </el-button>
    </el-form>
  </div>
</template>

<script lang="ts">
import {defineComponent, reactive, ref, toRefs} from "vue";
import {LoginData, LoginRes} from "@/entity/param/RegisterParam";
import {FormInstance, FormRules} from "element-plus";
import {login} from "@/request/registerRequest";
import {getStore} from "@/conf/store";
import router from "@/conf/router";


export default defineComponent({
  setup() {
    let store = getStore();

    const data = reactive(new LoginData());
    const rules = reactive<FormRules>({
      password: [
        {
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        },
        {
          min: 5,
          max: 12,
          message: '请输入5-12位密码',
          trigger: 'blur'
        },
      ],
      username: [
        {
          required: true,
          message: '请输入用户名',
          trigger: 'blur'
        }
      ],
    });
    const loginFormRef = ref<FormInstance>();
    const loginFunc = (loginFormRef: FormInstance | undefined) => {
      if (!loginFormRef) {
        return;
      }
      loginFormRef.validate((isValid => {
        if (!isValid) {
          return false;
        }
        login(data.formData).then((res: LoginRes) => {
          localStorage.setItem('token', res.data.token);
          localStorage.setItem("loginUserName", res.data.name);
          localStorage.setItem("loginRegisterId", res.data.registerId.toString());
          store.commit("refresh");
          router.push('/');
        })
      }));
    };

    return {...toRefs(data), rules, loginFunc, loginFormRef};
  }
})
</script>

<style lang="scss" scoped>
.login-box :deep {
  width: 100%;
  margin: 0 auto;

  .el-input .el-input__wrapper.is-focus {
    border-bottom: 1px solid greenyellow;
  }

  .el-input .el-input__wrapper {
    background-color: rgba(255, 255, 255, 0);
    color: white;
    border-radius: 0;
    border-bottom: 1px solid white;
    box-shadow: 0 0;
  }

  .el-input .el-input__inner {
    color: white;
  }

  .el-button {
    border: 1px solid white;
    color: white;
  }

  .el-button {
    --el-button-hover-text-color: greenYellow !important;
    --el-button-disabled-border-color: grey !important;
    --el-button-disabled-text-color: grey !important;
    background-color: rgba(255, 255, 255, 0);

    .el-icon {
      color: white;
    }
  }

  .el-button:active {
    border: 1px solid greenyellow;
    color: white;
  }

  .el-button:hover {
    color: greenyellow;
  }

  .label {
    color: white;
  }

  .login-form {
    text-align: center;
    width: 30%;
    margin: 10% auto;
    background: transparent;
    padding: 40px 40px 40px 40px;
    border: 1px solid white;
    border-radius: 20px;

    h2 {
      margin-bottom: 20px;
    }
  }

  .loginBtn {
  }
}

</style>