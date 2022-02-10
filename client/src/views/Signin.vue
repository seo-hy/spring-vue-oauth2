<template>
  <div class="form">
    <form action="">
      <div class="form__field">
        <label for="id">id</label>
        <input type="text" id="id" placeholder="아이디" v-model="loginId" />
      </div>
      <div class="form__field">
        <label for="name">name</label>
        <input type="text" id="name" placeholder="이름" v-model="name" />
      </div>
      <div class="form__field">
        <label for="password">password</label>
        <input type="text" id="password" placeholder="비밀번호" v-model="password" />
      </div>
      <div class="form__field">
        <label for="phone">phone</label>
        <input type="text" id="phone" placeholder="전화번호" v-model="phone" />
      </div>
      <div class="form__field">
        <input type="submit" @click="signup" value="Signup" />
      </div>
      <button
        @click="
          $router.push({
            name: 'login',
          })
        "
      >
        Login
      </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      loginId: "",
      name: "",
      password: "",
      phone: "",
    };
  },
  methods: {
    signup() {
      axios
        .post("localhost:8081/api/user/signup", {
          loginId: this.loginId,
          name: this.name,
          password: this.password,
          phone: this.phone,
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped></style>
