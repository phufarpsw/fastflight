<template>
  <div id="id" class="relative">
    <nav class="flex relative select-none justify-between px-12 py-4">
      <div class="logo flex w-1/3 justfiy-center space-x-2 items-center">
        <img src="../../assets/logo.png" alt="" />
        <p class="text-lg">FASTFLIGHT</p>
      </div>
      <div class="group-menubar text-sm w-1/3 flex justify-between items-center">
        <p class="cursor-pointer">HOME</p>
        <p class="cursor-pointer">FLIGHT</p>
        <p class="cursor-pointer">PROMO</p>
      </div>
      <div v-show="token === null" class="login flex w-1/3 justify-end items-center ">
        <p class="cursor-pointer" @click="openLogin()">LOGIN</p>
      </div>
      <div v-show="token !== null" class="dropdown w-1/3 flex justify-end relative">
        <button class="font-semibold rounded inline-flex items-center relative">
          <img width="30px" src="../../assets/profile.svg" alt="" />
          <span class="mx-3 text-sky-700 font-copper text-sm uppercase">{{ user.firstName+" "+user.lastName }}</span>
          <img src="../../assets/dropdown-icon.svg" alt="">
        </button>
        <ul class="w-5/12 dropdown-menu hidden cursor-pointer absolute text-gray-700 mt-10 pt-1 shadow-md z-50" >
          <li class="">
            
              <p class="py-2 px-4 block whitespace-no-wrap" style="background-color:#EFEFEF; border-top-left-radius:0.375rem; border-top-right-radius:0.375rem;">
                Account
              </p>

          </li>
          <li class="bg-white hover:bg-gray-200 py-3 px-4 text-xs flex items-center space-x-2">
              <img width="22px" src="../../assets/profile.svg" alt="" />
            <p class="">
              Profile
            </p>
          </li>
          <li class="bg-white hover:bg-gray-200 py-3 px-4 text-xs flex items-center space-x-2" style="border-bottom-left-radius:0.375rem; border-bottom-right-radius:0.375rem;">
              <img width="22px" src="../../assets/signOut-icon.svg" alt="" />
            <p class="">
              Sign Out
            </p>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  name: "Navbar",
  data() {
    return {
      token: localStorage.getItem("user"),
      user : [],
    };
  },
  mounted(){
    this.getData();
  },
  methods: {
    getData(){
      let token = JSON.parse(localStorage.getItem("user"));
      axios
          .post(`http://localhost:9001/passengers/getUserByUsername`, {username : token.username})
          .then(response => {
            this.user = response.data;
            // console.log(this.loginuser)
          })
          .catch(error => {
            this.error = error.response.data.message;
          });
    },
    openLogin(){
      $(".loginModal").fadeIn();
    },
  }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Prompt&display=swap');

@font-face {
  font-family: "Copperplate";
  src: url(../../../public/fonts/Copperplate\ Gothic\ Bold\ Regular.ttf);
}

nav {
  border-bottom: 1px solid #525197;
}

nav>div>p {
  font-family: "Copperplate";
}

.font-copper {
  font-family: "Copperplate";
}
</style>
