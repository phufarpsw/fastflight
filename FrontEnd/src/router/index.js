import Vue from "vue";
import VueRouter from "vue-router";
// import Home from "../views/Home.vue"
// import Test from "../views/Test.vue"

Vue.use(VueRouter);
const router = new VueRouter({
  routes: [{ 
    path: '/',
    name: "home",
    component: () => import("../views/Home.vue")
  },
  {
    path: '/test',
    name: "test",
    // meta: { guest: true },
    component : () => import('../views/Test.vue')
  }
]
});
//You don’t have the right to update

// const router = new VueRouter({
//   routes
// })
// router.beforeEach((to, from, next) => {
//   const isLoggedIn = !!localStorage.getItem('user')

//   if (to.meta.login && !isLoggedIn) {
//     alert('Please login first!')
//     next({ path: '/login' })
//   }

//   if (to.meta.guest && isLoggedIn) {
//     alert("You've already logged in")
//     next({ path: '/'})
//   }

//   next()
// })

export default router;
