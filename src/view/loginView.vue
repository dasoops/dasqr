<template>
  <div class="login-box">
    <el-form
        ref="loginFormRef"
        :model="formData"
        status-icon
        :rules="rules"
        label-width="80px"
        class="login-form"
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
      <el-form-item>
        <el-button class="loginBtn" type="primary" @click="loginFunc(loginFormRef)"
        >登录
        </el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
import {defineComponent, reactive, ref, toRefs} from "vue";
import {useRouter} from "vue-router";
import {LoginData, LoginRes} from "@/entity/param/RegisterParam";
import {FormInstance, FormRules} from "element-plus";
import {login} from "@/request/RegisterRequest";
import {getStore} from "@/conf/store";


export default defineComponent({

  setup() {
    let router = useRouter();
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
          router.push('/config');
          store.commit("refresh");
        })
      }));
    };

    return {...toRefs(data), rules, loginFunc, loginFormRef};
  }
})
</script>

<style lang="scss" scoped>
.login-box {
  width: 100%;
  margin: 0 auto;

  .label {
    color: white;
  }

  .login-form {
    width: 30%;
    margin: 10% auto;
    background-color: rgba(255, 255, 255, 0.1);
    padding: 20px 40px 20px 20px;
    border-radius: 20px;

    h2 {
      margin-bottom: 20px;
    }
  }

  .loginBtn {
    margin: 10px 10px 10px 38%;
  }
}

</style>