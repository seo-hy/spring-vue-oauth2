<template>
  <div>
    <NavBar />
    <div>home</div>
  </div>
</template>

<script>
import axios from "axios";
import NavBar from "../components/nav/NavBar.vue";

export default {
  created() {
    this.connectionTest();
  },
  components: {
    NavBar,
  },
  methods: {
    connectionTest() {
      axios
        .get("http://localhost:8081/api/test")
        .then((res) => {
          this.notifySuccessMessage(res.data);
        })
        .catch((err) => {
          this.notifyErrorMessage(err);
        });
    },
    notifySuccessMessage(message) {
      this.$notify({
        group: "mainNotify",
        type: "success",
        duration: 3000,
        title: message,
        // text: message,
      });
    },
    notifyErrorMessage(message) {
      this.$notify({
        group: "mainNotify",
        type: "error",
        duration: 3000,
        title: message,
        // text: message,
      });
    },
  },
};
</script>

<style></style>
