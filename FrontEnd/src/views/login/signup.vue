<template>
    <div class="
      absolute
      signUpModal
      flex
      justify-center
      items-center
      w-screen
      h-screen
      z-50
    ">
        <div class="absolute bg-white z-50 rounded-lg py-8 px-14" style="width: 700px; height: 500px">
            <p class="absolute px-7 py-5 text-xl cursor-pointer" style="top: 0; right: 0" @click="closeSignupModal()">
                X
            </p>
            <p class="text-3xl tracking-widest font-semibold font-chakra" style="color: #636161">
                Hi !
            </p>
            <div class="space-y-4">
                <div class="flex space-x-2" style="color: #817a7a">
                    <p class="font-chakra font-thin">Create</p>
                    <p class="font-chakra font-thin">a</p>
                    <p class="font-chakra font-thin">new</p>
                    <p class="font-chakra font-thin">account</p>
                </div>
                <div class="w-full flex space-x-2" style="width: 550px">
                    <label class="relative block">
                        <span class="
                absolute
                inset-y-0
                left-0
                flex
                justify-center
                items-center
                pl-3
              ">
                            <img width="25px" src="../../../src/assets/username-icon.svg" alt="" />
                        </span>
                        <input v-model="firstName" class="
                w-full
                thai-font
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
              " placeholder="ชื่อจริง" type="text" />
                    </label>
                    <label class="relative block">
                        <span class="
                absolute
                inset-y-0
                left-0
                flex
                justify-center
                items-center
                pl-3
              ">
                            <img width="25px" src="../../../src/assets/username-icon.svg" alt="" />
                        </span>
                        <input v-model="lastName" class="
                w-full
                thai-font
                text-sm
                placeholder-gray-400
                bg-white
                border border-slate-300
                rounded-md
                py-2.5
                pl-12
                pr-4
                focus:outline-n
                one
                peer
              " placeholder="นามสกุล" type="text" />
                    </label>
                </div>
                <div class="w-full flex space-x-2" style="width: 550px">
                    <label class="relative block">
                        <span class="
                absolute
                inset-y-0
                left-0
                flex
                justify-center
                items-center
                pl-3
              ">
                            <img width="25px" src="../../../src/assets/username-icon.svg" alt="" />
                        </span>
                        <input v-model="tel" class="
                w-full
                thai-font
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
              " placeholder="หมายเลขโทรศัพท์มือถือ" type="text" />
                    </label>
                    <label class="relative block">
                        <span class="
                absolute
                inset-y-0
                left-0
                flex
                justify-center
                items-center
                pl-3
              ">
                            <img width="25px" src="../../../src/assets/email-icon.svg" alt="" />
                        </span>
                        <input v-model="email" class="
                w-full
                thai-font
                text-sm
                placeholder-gray-400
                bg-white
                border border-slate-300
                rounded-md
                py-2.5
                pl-12
                pr-4
                focus:outline-n
                one
                peer
              " placeholder="อีเมล" type="text" />
                    </label>
                </div>
                <div class="w-full space-y-4" style="width: 550px">
                    <label class="relative block">
                        <span class="
                absolute
                inset-y-0
                left-0
                flex
                justify-center
                items-center
                pl-3
              ">
                            <img width="25px" src="../../../src/assets/idcard-icon.svg" alt="" />
                        </span>
                        <input v-model="idCard" class="
                w-full
                thai-font
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
              " placeholder="หมายเลขบัตรประชาชน" type="text" minlength="13" maxlength="13" required />
                    </label>
                    <label class="relative block">
                        <span class="
                absolute
                inset-y-0
                left-0
                flex
                justify-center
                items-center
                pl-3
              ">
                            <img width="25px" src="../../../src/assets/username-icon.svg" alt="" />
                        </span>
                        <input v-model="username" class="
                w-full
                thai-font
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
                    <label class="relative block">
                        <span class="
                absolute
                inset-y-0
                left-0
                flex
                justify-center
                items-center
                pl-3
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
              " placeholder="Password" type="text" />
                    </label>

                    <div class="">
                        <button type="submit" @click="registerData()" class="
                search
                w-full
                text-white
                focus:ring-1 focus:outline-none focus:ring-purple-300
                font-thin
                font-copper
                rounded-md
                text-md
                px-5
                py-2
                text-center
                items-center
                dark:bg-blue-600 dark:focus:ring-purple-400
              ">
                            SIGN UP
                        </button>
                        <div class="mt-4 flex justify-center items-center">
                            <p class="font-chakra tracking-wide" style="color: #817a7a">
                                Already an FastFlight member?
                                <span @click="openLoginModal()" class="
                    font-chakra
                    tracking-widest
                    font-semibold
                    cursor-pointer
                  " style="color: #454444">
                                    Sign In now</span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="w-full h-full" style="background-color: #787373; opacity: 75%"></div>
    </div>
</template>
<script>
import axios from 'axios';
import { required, email, minLength, sameAs, maxLength } from 'vuelidate/lib/validators'
export default {
    name: "Signup",
    components: {
        // SignIn: SignIn
    },
    data() {
        return {
            username: "",
            password: "",
            firstName: "",
            lastName: "",
            idCard: "",
            email: "",
            tel: "",
        }
    },
    methods: {
        openLoginModal() {
            $(".loginModal").fadeIn();
            this.closeSignupModal();
        },
        closeSignupModal() {
            $(".signUpModal").fadeOut()
        },
        registerData() {
            let check = {
                "username": this.username,
                "password": this.password,
                "firstName": this.firstName,
                "lastName": this.lastName,
                "idCardNumber": this.idCard,
                "email": this.email,
                "tel": this.tel
            };
            window.dialog.show({
                content: 'Are you sure want to continue?',
                okText: 'Yes',
                cancelText: 'Cancel',
                onOk: () => {
                    axios.post("http://localhost:9001/passengers", check)
                    .then((res) => {
                        if (res.data != "CreatePassenger Error" && res.data != "Please input your idCardNumber") {
                            this.closeSignupModal();
                            alert("Register Success");
                        }
                        else {
                            alert("Register Failed");
                        }
                        location.reload();
                    }).catch(err => {
                        console.log(err);
                    })
                },
                onCancel: () => { console.log('You clicked cancel button') }
            });
        }
    }
};
</script>
<style>
.thai-font {
    color: #817a7a !important;
    font-family: "Prompt", sans-serif;
}
</style>
