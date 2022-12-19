<template>
    <div class="absolute loginModal flex justify-center items-center w-screen h-screen z-50">
        <div class="absolute bg-white z-50 rounded-lg py-8 px-10" style="width: 600px; height: 390px">
            <p class="absolute px-7 py-5 text-xl cursor-pointer" style="top:0; right:0" @click="closeLoginModal()">X</p>
            <p class="text-3xl tracking-widest font-semibold font-chakra" style="color: #636161">
                Welcome !
            </p>
            <div class="flex space-x-2 px-2" style="color:#817A7A">
                <p class="font-chakra font-thin">Sign</p>
                <p class="font-chakra font-thin">in</p>
                <p class="font-chakra font-thin">to</p>
                <p class="font-chakra font-thin">continue</p>
            </div>

            <div class="w-full" style="width: 500px">
                <label class="relative block p-4">
                    <span class="
              absolute
              inset-y-0
              left-0
              flex
              justify-center
              items-center
              pl-7
            ">
                        <img width="25px" src="../../../src/assets/username-icon.svg" alt="" />
                    </span>
                    <input v-model="username" class="
              w-full
              font-chakra
              text-sm
              placeholder-gray-400
              bg-white
              border border-slate-300
              rounded-md
              py-2.5
              pl-12
              pr-4
              focus:outline-none
              peer
            " placeholder="Username" type="text" />
                </label>
                <label class="relative block p-4">
                    <span class="
              absolute
              inset-y-0
              left-0
              flex
              justify-center
              items-center
              pl-7
            ">
                        <img width="25px" src="../../../src/assets/password-icon.svg" alt="" />
                    </span>
                    <input v-model="password" class="
              w-full
              font-chakra
              text-sm
              placeholder-gray-400
              bg-white
              border border-slate-300
              rounded-md
              py-2.5
              pl-12
              pr-4
              focus:outline-none
              peer
            " placeholder="Password" type="password" />
                </label>
                <div class="px-4 mt-4">
                    <button @click="loginPassenger()" type="submit" class="
                search
                font-copper
                w-full
                text-white
                focus:ring-1 focus:outline-none focus:ring-purple-300
                font-medium
                rounded-md
                text-md
                px-5
                py-2
                text-center
                items-center
                dark:bg-blue-600 dark:focus:ring-purple-400
              ">
                        LOGIN
                    </button>
                    <div class="mt-4 flex justify-center items-center">
                        <p class="font-chakra tracking-wide" style="color:#817A7A">Not an FastFlight member?
                            <span @click="openRegisterModal()" class="font-chakra tracking-widest font-semibold cursor-pointer"
                                style="color:#454444"> Sign up now</span>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="w-full h-full" style="background-color: #787373; opacity: 75%"></div>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    name: "Login",
    data(){
        return {
            username: "",
            password: "",
            openRegister : false
        }
    },
    methods: {
        loginPassenger() {
            let check = {
                "username": this.username,
                "password": this.password,
            };
            axios.post("http://localhost:9001/passengers/login", check)
                .then((res) => {
                    if (res.data._id != null) {  
                        this.closeLoginModal();
                        localStorage.setItem("user", JSON.stringify(res.data));
                        location.reload();
                        alert("Login Success");
                    }
                    else {
                        alert("Login Failed");
                    }
                }).catch(err => {
                    console.log(err);
                })
        },
        closeLoginModal() {
            $(".loginModal").fadeOut()
        },
        openRegisterModal(){
            this.closeLoginModal();
            $(".signUpModal").fadeIn()
        }
    }
}
</script>