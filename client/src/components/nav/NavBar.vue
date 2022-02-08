<template>
  <div class="nav-bar">
    <div class="nav-bar-default">
      <router-link to="/">HOME</router-link>
      <router-link to="/info">INFO</router-link>
      <router-link to="/community">COMMUNITY</router-link>
      <router-link to="/log">LOG</router-link>
    </div>

    <div v-if="isAuth" class="nav-bar-auth">
      <router-link to="/mypage">mypage</router-link>
      <div>logout</div>
    </div>
    <div v-else class="nav-bar-auth">
      <router-link to="/signin">signin</router-link>
      <router-link to="/login">login</router-link>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isAuth: false,
    };
  },
  methods: {
    login() {},
  },
};
</script>

<style scoped>
.nav_bar {
  background-color: rgb(207, 206, 201);
}
</style>
