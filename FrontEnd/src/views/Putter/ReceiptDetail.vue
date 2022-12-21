<template>
  <div id="app" class="relative h-screen">
    <Navbar />
    <div class="flex justify-center items-center mt-24">
      <div
        class="
          container-form
          justfiy-center
          items-center
          bg-white
          rounded-lg
        "
      >
      <div class="border-b py-6 px-7 flex justify-between">
        <div class="">
            <p class="ml-6 justify-self-center self-center font-medium topic-font text-2xl mb-2 font-medium" style="color : #636161">Detail</p>
                <p class="ml-6 justify-self-center self-center font-extralight topic-font text-lg text-slate-500">Tue, 17 Dec 2022 | 1 Travelers</p>
        </div>
        <button
              type="submit"
              id="flip"
              class="
                search
                font-copper
                text-white
                focus:ring-1 focus:outline-none focus:ring-purple-300
                font-medium
                rounded-md
                text-sm
                px-5
                py-2
                text-center
                items-center
                dark:bg-blue-600 dark:focus:ring-purple-400
                h-10
                self-center
              "
            >
              EXPORT PDF
            </button>
            </div>
        <div class="w-full px-12 flex flex-col my-6">
            <div class="image-container mt-6 mb-6">
                <div class="">
                    <img src="../../assets/Receipt.svg" alt="">
                <div class="left-content">
                    <p class=" text-2xl thai-font text-left">฿ 17,444</p>
                    <p class=" text-xl thai-font mt-9 text-left">17 Jan 2023</p>
                </div>
                <div class="right-content">
                    <div class="flex">
                        <div class="">
                            <p class=" text-3xl thai-font text-left">BKK</p>
                    <p class=" text-lg thai-font text-left font-extralight">Bangkok</p>
                        </div>
                        <div class="ml-44">
                            <p class=" text-3xl thai-font text-left">NRT</p>
                    <p class=" text-lg thai-font text-left font-extralight">Tokyo</p>
                        </div>
                    </div>
                    <div class="flex mt-3">
                        <div><p class="text-lg thai-font text-left">Somjai kaigai</p>
                        <p class="text-left thai-font font-thin">Name</p></div>
                        <div class="ml-20">
                            <p class="text-lg thai-font text-left">TR607</p>
                            <p class="text-left thai-font font-thin"> Flight</p>
                        </div>
                    </div>
                    <div class="flex mt-3">
                        <div><p class="thai-font text-lg text-left">12:55</p>
                        <p class="thai-font text-sm font-thin text-left">Depature</p></div>
                        <div class="ml-12">
                        <p class="thai-font text-lg">6:00</p>
                        <p class="thai-font text-sm font-thin">Arrival</p>
                    </div>
                    <div class="ml-12">
                        <p class="thai-font text-lg">3B</p>
                        <p class="thai-font text-sm font-thin">Seat</p>
                    </div>
                    <div class="ml-12">
                        <p class="thai-font text-lg">6</p>
                        <p class="thai-font text-sm font-thin">Gate</p>
                    </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import navbar from "../component/navbar.vue";
import Vue from 'vue';
export default {
  name: "Home",
  components: {
    Navbar: navbar,
  },
  data(){
    return {
      flightMode : "multiple",
      goDate: null,
      attrs: [
        {
          highlight: {
            start: { fillMode: 'outline' },
            base: { fillMode: 'outline' },
            end: { fillMode: 'outline' },
          },
        },
      ],
    range: {
      start: null,
      end: null
    }
    };
  },
  methods : {
    setOneFlightTrue(){
      this.oneFlight = true
    },
    
  },
  mounted(){
    if (JSON.parse(localStorage.getItem("passenger")) == null){
      alert("Please Login First !")
      this.$router.push('/')

    }
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.font-copper{
  font-family: "Copperplate";
}
.thai-font {
  font-family: "Prompt", sans-serif;
}
.left-content {
  position: absolute;
  top: 108px;
  left: 40px;
}
.right-content {
  position: absolute;
  top: 30px;
  left: 286px;
}
#app {
  background-color: #dbdaff;
  background-image: url("../../assets/bg.svg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: bottom;
  background-attachment: fixed;
}

.image-container{
    position: relative;
  text-align: center;
  color: white;
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
.seat-select > option{
  padding-top: 10rem;
}
</style>
