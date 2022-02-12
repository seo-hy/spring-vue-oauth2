<template>
  <div id="app">
    <NavBar v-if="isAuth" />
    <router-view></router-view>
  </div>
</template>

<script>
import axios from "axios";
import NavBar from "./components/nav/NavBar.vue";
export default {
  name: "app",
  components: {
    NavBar,
  },
  created() {
    this.connectionTest();
  },
  data() {
    return {
      notifyType: {
        success: "success",
        error: "error",
      },
      isAuth: false,
    };
  },
  methods: {
    connectionTest() {
      axios
        .get("http://localhost:8081/api/test")
        .then((res) => {
          this.notifyMessage(this.notifyType.success, res.data);
        })
        .catch((err) => {
          this.notifyMessage(this.notifyType.error, err);
        });
    },
    notifyMessage(type, title) {
      this.$notify({
        group: "mainNotify",
        type: type,
        duration: 3000,
        title: title,
        // text: message,
      });
    },
  },
};
</script>

<style>
html,
body,
#app {
  margin: 0px;
  padding: 0px;
  width: 100%;
  height: 100%;
}
</style>
