<template>
  <div class="nav-bar">
    <ul>
      <router-link tag="li" :to="{ name: 'home' }">Home</router-link>
      <router-link tag="li" :to="{ name: 'info' }">Info</router-link>
      <router-link tag="li" :to="{ name: 'community' }">Community</router-link>
      <router-link tag="li" :to="{ name: 'setting' }">Setting</router-link>
      <div v-if="isAuth" class="nav-bar-auth">
        <router-link to="/mypage">mypage</router-link>
        <div>logout</div>
      </div>
      <div v-else class="nav-bar-auth">
        <router-link tag="li" to="/signup">signup</router-link>
        <router-link tag="li" to="/ogin">login</router-link>
      </div>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isAuth: false,
    };
  },
};
</script>

<style scoped>
.nav-bar {
  background-color: rgb(247, 247, 245);
  width: 800px;
  height: 50px;
  margin: 0 auto;
  line-height: 50px;
}
ul {
  margin: 0;
  list-style-type: none;
}
li {
  cursor: pointer;
  float: left;
}

ul > li {
  color: rgba(38, 138, 116, 0.856);
  text-decoration: none;
  font-size: 20px;
  font-weight: 500;
  margin: 0 35px;
}
.nav-bar-menu {
  height: 100%;
}
.nav-bar-auth {
  width: 150px;
  height: 30px;
  background-color: rgb(196, 196, 196);
  margin-top: 10px;
  margin-left: 20px;
  display: inline-block;
  text-align: center;
  line-height: 30px;
}
.nav-bar-auth > li {
  font-size: 15px;
  text-decoration: none;
  margin: 0 15px;
}
</style>
