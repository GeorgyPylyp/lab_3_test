import { createRouter, createWebHistory } from "vue-router";
import Home from "../pages/Home.vue";
import Products from "../pages/Products.vue";
import Cart from "../pages/Cart.vue";

const routes = [
  { path: "/", component: Home },
  { path: "/products", component: Products },
  { path: "/cart", component: Cart },
];

export default createRouter({
  history: createWebHistory(),
  routes,
});
