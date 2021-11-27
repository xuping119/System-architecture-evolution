
import Vue from 'vue'
import App from './App'
import router from './router'
import Element from 'element-ui'
import VueResource from 'vue-resource'
Vue.use(Element)


<template>
  <div>
    <el-form :model="login" status-icon :rules="rule" ref="login">
      <b>用户名</b>
      <el-form-item prop="username" >
        <el-input prefix-icon="el-icon-ump-yonghu" v-model="login.username" auto-complete="off" />
      </el-form-item>

      <b>密码</b>
      <el-form-item prop="password">
        <el-input prefix-icon="el-icon-ump-mima" type="password" v-model="login.password" auto-complete="off" />
      </el-form-item>

      <el-form-item>
        <el-button class="btn" type="primary" @click="submitForm('login')">登录</el-button>
      </el-form-item>
    </el-form>

    <p><a href="#" class="tips">还没有账号？点我去注册</a></p>
  </div>
</template>

<script>
    export default {
      name: 'login',
      data() {
        var checkUsername = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入用户名'));
          } else {
            callback();
          }
        };
        var checkPassword = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            callback();
          }
        };
        return {
          checked: false,
          token: '',
          login: {
            username: '',
            password: ''
          },
          rule: {
            username: [{
              validator: checkUsername,
              trigger: 'blur'
            }
            ],
            password: [{
              validator: checkPassword,
              trigger: 'blur'
            }]
          }
        }
      },
      methods: {
        submitForm(login){
          this.$refs[login].validate((valid)=>{
            if(valid){
              var user = JSON.stringify({name:this.login.username,password:this.login.password})

              this.$http.post('http://127.0.0.1:8081/login',user,{emulateJSON:true}).then(result =>{
                console.log(result);
                if(result.data.code ==='1000'){
                  this.$router.push({path:'home'});
                }else{
                  console.log("登录失败");
                  return false;
                }
              });
            }else{
              console.log("error submit!!");
              return false;
            }
          });
        },
      },
    }
</script>

<style scoped>

</style>
