<template>
  <div id="app" class="relative pb-20"
    style="background-attachment:scroll; background-position:bottom; background-size:contain">
    <SignUp v-show="openRegister" />
    <Login v-show="openLogin" />
    <Navbar />
    <!-- Carousel -->
    <div class="w-full flex justify-center overflow-hidden" style="height:500px; background-color: #a590c7">
      <carousel :paginationEnabled="false" :perPage="1" class="w-full" style="height:500px">
        <slide class="bg-red-200" style="height:500px">
        </slide>
        <slide class="bg-red-200" style="height:500px">
          Slide 2 Content
        </slide>
      </carousel>
    </div>
    <!-- Content -->
    <div class="w-full px-52 py-16">
      <p class="text-center thai-font text-4xl" style="color: #636161">
        Why Fast Flight?
      </p>
      <div class="flex mt-20 justify-between">
        <div class="w-1/4 text-center">
          <img src="../assets/homepagepic1.svg" alt="" class="block mx-auto mb-8" />
          <p class="chakra-font text-xl mb-4 font-semibold" style="color: #454444">
            Simplify Your Booking Experience
          </p>
          <p class="thai-font" style="color: #817a7a">
            Feel the flexibility and simplicity throughout your booking process
          </p>
        </div>
        <div class="w-1/4 text-center flex flex-col justify-center">
          <img src="../assets/homepagepic2.svg" alt="" class="block mx-auto mb-8" />
          <p class="chakra-font text-xl mb-4 font-semibold" style="color: #454444">
            World's Local Booking Excitement
          </p>
          <p class="thai-font" style="color: #817a7a">
            Stress-free booking experience with local payment, currency, and
            language
          </p>
        </div>
        <div class="w-1/4 text-center">
          <img src="../assets/homepagepic3.svg" alt="" class="block mx-auto mb-8" />
          <p class="chakra-font text-xl mb-4 font-semibold" style="color: #454444">
            Wide Selections of Travel Product
          </p>
          <p class="thai-font" style="color: #817a7a">
            Enjoy your memorable moments with millions of favorable flights and
            accommodations
          </p>
        </div>
      </div>
      <div class="flex mt-20 justify-between">
        <div class="w-1/4 text-center">
          <img src="../assets/homepagepic4.svg" alt="" class="block mx-auto mb-8" />
          <p class="chakra-font text-xl mb-4 font-semibold" style="color: #454444">
            Exclusive Offer Everyday
          </p>
          <p class="thai-font" style="color: #817a7a">
            Various daily promo with competitive price for all travelers
          </p>
        </div>
        <div class="w-1/4 text-center">
          <img src="../assets/homepagepic5.svg" alt="" class="block mx-auto mb-8" />
          <p class="chakra-font text-xl mb-4 font-semibold" style="color: #454444">
            Online Booking Expert
          </p>
          <p class="thai-font" style="color: #817a7a">
            Together with our credible partners, fulfilling countless traveler's
            needs since 2011
          </p>
        </div>
        <div class="w-1/4 text-center">
          <img src="../assets/homepagepic6.svg" alt="" class="block mx-auto mb-8" />
          <p class="chakra-font text-xl mb-4 font-semibold" style="color: #454444">
            Affectionate Customer Support
          </p>
          <p class="thai-font" style="color: #817a7a">
            Giving best assistance, our customer support is available 24/7 with
            your local language
          </p>
        </div>
      </div>
    </div>
    <!-- Popular Hotel -->
    <div class="w-full px-44">
      <p class="thai-font text-2xl" style="color : #454444">Popular Hotel</p>
      <div class="flex mt-12 justify-between">
        <div class="bg-white rounded-lg w-1/5">
          <img src="../assets/pophotel1.svg" alt="" class="w-full">
          <div class="p-5">
            <p class="thai-font text-lg font-bold" style="color : #454444">Grande Centre Point Hotel
            </p>
            <p class="thai-font" style="color : #817A7A">Terminal 21 SHA Plus+</p>
            <p class="text-end thai-font mt-2" style="color : #454444">From ฿ 6,160</p>
          </div>
        </div>
        <div class="bg-white rounded-lg w-1/5">
          <img src="../assets/pophotel2.svg" alt="" class="w-full">
          <div class="p-5">
            <p class="thai-font text-lg font-bold" style="color : #454444">Emporium Suites
            </p>
            <p class="thai-font" style="color : #817A7A">by Chatrium SHA Plus+</p>
            <p class="text-end thai-font mt-2" style="color : #454444">From ฿ 3,490</p>
          </div>
        </div>
        <div class="bg-white rounded-lg w-1/5">
          <img src="../assets/pophotel3.svg" alt="" class="w-full">
          <div class="p-5">
            <p class="thai-font text-lg font-bold" style="color : #454444">Banyan Tree
            </p>
            <p class="thai-font" style="color : #817A7A">Bangkok SHA Plus+</p>
            <p class="text-end thai-font mt-2" style="color : #454444">From ฿ 9,660</p>
          </div>
        </div>
        <div class="bg-white rounded-lg w-1/5">
          <img src="../assets/pophotel4.svg" alt="" class="w-full">
          <div class="p-5">
            <p class="thai-font text-lg font-bold" style="color : #454444">The Westin Grande Sukhumvit
            </p>
            <p class="thai-font" style="color : #817A7A">Bangkok SHA Extra</p>
            <p class="text-end thai-font mt-2" style="color : #454444">From ฿ 8,470</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import navbar from "./component/navbar.vue";
import { Carousel, Slide } from 'vue-carousel';
import SignUp from "./login/signup.vue";
import Login from './login/login.vue';
export default {
  name: "home",
  components: {
    Navbar: navbar,
    SignUp: SignUp,
    Login: Login,
    Carousel,
    Slide
  },
  data() {
    return {
      activeHome: true,
      options: {
        rewind: true,
        width: 800,
        gap: "1rem",
      },
    };
  },
  methods: {},
  mounted() {
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

h1 {
  height: 100%;
  padding: 0;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
  background: linear-gradient(90deg,
      rgba(88, 140, 236, 1),
      rgba(106, 106, 207, 1));
}

.font-copper {
  font-family: "Copperplate";
}

.font-chakra {
  font-family: 'Chakra Petch', sans-serif;
}

.image-container {
  position: relative;
  text-align: center;
  color: white;
}

.text-seat {
  text-overflow: ellipsis;
  width: 150px;
  overflow: hidden;
  white-space: nowrap;
}

.thai-font {
  font-family: "Prompt", sans-serif;
}

.left-content {
  position: absolute;
  top: 260px;
  left: 197px;
}

.num-size {
  width: 9px;
}

.seat {
  width: 40px;
  height: 72px;
}

#app {
  background-color: #dbdaff;
  background-image: url("../assets/bg.svg");
  background-size: contain;
  background-repeat: no-repeat;
  background-position: bottom;
  /* background-attachment: fixed; */
}

.seat-selected {
  background-color: #dcc7ff;
}

.seat-reserved {
  color: #d9d9d9;
  background-color: #d9d9d9;
  cursor: not-allowed;
}

.container-form {
  width: 800px;
  box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px,
    rgba(60, 64, 67, 0.15) 0px 2px 6px 2px;
}

button.search {
  background-color: #a590c7 !important;
}

input[type="radio"] {
  border-style: solid;
  border-width: 0.1rem;
  border-color: gray;
  /* background: radial-gradient(teal 0%, teal 40%, transparent 50%, transparent); */
  accent-color: #652f71;
}

.seat-select>option {
  padding-top: 10rem;
}
</style>
