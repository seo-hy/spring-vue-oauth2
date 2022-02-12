import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Signup from "../views/Signup.vue";
import Login from "../views/Login.vue";
import Info from "../views/Info.vue";
import Community from "../views/Community.vue";
import Setting from "../views/Setting.vue";
import MyPage from "../views/MyPage.vue";
import NotFound from "../views/NotFound.vue";

Vue.use(VueRouter);

const router = new VueRouter({
  mode: "history",
  routes: [
    {
      name: "home",
      path: "/",
      component: Home,
    },
    {
      name: "signup",
      path: "/signup",
      component: Signup,
    },
    {
      name: "login",
      path: "/login",
      component: Login,
    },
    {
      name: "community",
      path: "/community",
      component: Community,
    },
    {
      name: "info",
      path: "/info",
      component: Info,
    },
    {
      name: "setting",
      path: "/setting",
      component: Setting,
    },
    {
      name: "mypage",
      path: "/mypage",
      component: MyPage,
    },
    {
      name: "notFound",
      path: "*",
      component: NotFound,
    },
  ],
});

export default router;
