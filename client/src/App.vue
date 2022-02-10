<template>
  <div id="app">
    <router-view></router-view>
    <notifications group="mainNotify" position="bottom right" />
  </div>
</template>

<script>
export default {
  name: "app",
};
</script>

<style>
body {
  margin: 0px;
}
</style>
