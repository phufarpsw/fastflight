import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);
const router = new VueRouter({
  routes: [
    {
      path: '/',
      name: "home",
      component : () => import("../views/HomePage.vue")
    },
    { 
    path: '/flight',
    name: "flight",
    component: () => import("../views/flight.vue")
  },
  {
    path: '/choose',
    name: "choose",
    component : () => import("../views/Choose Flight.vue")
  },
  {
    path: '/detail',
    name: "detail",
    component : () => import("../views/PassengerDetails.vue")
  },
  {
    path: '/seat',
    name: "seat",
    component : () => import("../views/Putter/ChooseSeat.vue")
  },
  {
    path: '/recipe',
    name: "recipe",
    component : () => import("../views/Putter/ReceiptDetail.vue")
  },
  {
    path: '/edit',
    name: "edit",
    component : () => import("../views/Passengers/EditProfile.vue")
  }
  
]
})
router.beforeEach((to, from, next) => {
  const isLoggedIn = !!localStorage.getItem('passengers')

  if (to.meta.login && !isLoggedIn) {
    alert('Please login first!')
    next({ path: '/login' })
  }

  if (to.meta.guest && isLoggedIn) {
    alert("You've already logged in")
    next({ path: '/'})
  }

  next()
})


export default router;
