import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Notifications from "vue-notification";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserSecret } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faUserSecret);

Vue.component("font-awesome-icon", FontAwesomeIcon);

Vue.config.productionTip = false;

Vue.use(Notifications);

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
