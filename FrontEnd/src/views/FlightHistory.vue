<template>
    <div id="app" class="relative h-screen">
        <Navbar/>
<div class="h-4/5 flex justify-center items-center">
        <div
        class="
          container-form
          flex
          justfiy-center
          items-center
          bg-white
          rounded-lg
        "
      >
      <div class="max-w-sm w-full lg:max-w-full lg:flex">
  <div class="border-r border-b border-l border-gray-400 lg:border-l-0 lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b-none lg:rounded-r flex flex-col leading-normal">
    <div class="mb-8">
        <div class=" border-b border-gray-200 py-6">
        <p class="ml-6 justify-self-center self-center font-medium topic-font text-2xl mb-2 font-medium">Depature flight to TOKYO</p>
        <p class="ml-6 justify-self-center self-center font-medium topic-font text-lg text-slate-500">Tue, 17 Dec 2022 | 1 Travelers</p>
        </div>
        <div
        class="
          container-form
          flex
          justfiy-center
          items-center
          rounded-lg
          mt-6
          justify-center
          border
          p-6
          mx-6
        "
      >
      <div class="flex justify-center items-center">
        <img src="../assets/flightlogo.svg"/>
        <div class="ml-4">
            <p>12:55</p>
            <p>BKK</p>
        </div>
        <img src="../assets/plane555.svg" class="ml-4"/>
        <div class="ml-4">
            <p>12:55</p>
            <p>BKK</p>
        </div>
        <div class="ml-4">
            <p>15h 5m</p>
            <p>Transit</p>
        </div>
        <p class="ml-12">฿ 7247 /pax</p>
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
                ml-12
              "
            >
              CHOOSE FLIGHT
            </button>
      </div>

        </div>
        <div class="flex items-center border mx-6 rounded-lg px-6 py-12">
            <div class="ml-4">
                <p class="text-2xl font-bold" style="color : #525197">TR607</p>
                <p class="text-slate-500">Flight</p>
            </div>
            <img src="../assets/PLANELINE.svg" class="ml-8"/>
            <div class="ml-8">
                <div class="flex">
                    <div class="ml-4">
                        <p class="text-lg font-bold">12:55</p>
                        <p class="text-slate-500">7 Dec 2022</p>
                    </div>
                    <div class="ml-12">
                        <p class="font-bold">Bangkok (BKK)</p>
                        <p class="text-slate-500">Suvarnabhum Airport</p>
                    </div>
                </div>
                <div class="flex ml-4 my-6">
                    <img src="../assets/clock.svg" class="mr-2"/>
                    <p class="text-slate-500">2h 5m</p>
                </div>
                <div class="flex">
                    <div class="ml-4">
                        <p class="text-lg font-bold">16:00</p>
                        <p class="text-slate-500">3 Jan 2023</p>
                    </div>
                    <div class="ml-12">
                        <p class="font-bold">Tokyo (NRT)</p>
                        <p class="text-slate-500">Narita International Airport</p>
                    </div>
                </div>
            </div>
            <div class="ml-12">
                <div class="flex">
                    <img src="../assets/nonrefund.svg" class="mr-4"/>
                <p class="text-slate-500">Non Refundable</p>
                </div>
                <div class="flex">
                    <img src="../assets/nonresche.svg" class="mr-4"/>
                <p class="text-slate-500">Non Reschedulable</p>
                </div>
                <div class="flex">
                    <img src="../assets/cabinbaggage.svg" class="mr-4"/>
                <p class="text-slate-700">Cabbin baggage 10 KG</p>
                </div>
                <div class="flex">
                    <img src="../assets/baggage.svg" class="mr-4"/>
                <p class="text-slate-700">Baggage 25 KG</p>
                </div>
                <div class="flex">
                    <img src="../assets/entertainment.svg" class="mr-4"/>
                <p class="text-slate-700">Entertainment</p>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("slow");
  });
});
</script>
<script>
import axios from "axios";
import navbar from "./component/navbar.vue";
import Vue from 'vue';
export default {
  name: "test",
  components: {
    Navbar: navbar,
  },
  data(){
    return {
    };
  },
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
.center-img{
  margin-left: auto;
  margin-right: auto;
}
.thai-font {
  color: #817a7a !important;
  font-family: "Prompt", sans-serif;
}
.topic-font {
  font-family: "Prompt", sans-serif;
}

#app {
  background-color: #dbdaff;
  background-image: url("../assets/mountain-bg.png");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: bottom;
}
#panel, #flip {
  padding: 5px;
  text-align: center;
  background-color: #e5eecc;
  border: solid 1px #c3c3c3;
}

#panel {
  padding: 50px;
  display: none;
}

.container-form {
  width: 800px;
}
.fname{
    position: relative;
    z-index: 2;
    float: left;
    width: 100%;
    margin-bottom: 0;
    display: table-cell;
    padding: 6px 12px;
    border: 1px solid #ccc;
    margin: 0;
}
.input-group-addon {
    padding: 6px 12px;
    font-size: 14px;
    font-weight: 400;
    line-height: 1;
    color: #555;
    text-align: center;
    background-color: #eee;
    border: 1px solid #ccc;
    white-space: nowrap;
    vertical-align: middle;
    display: table-cell;
}
.profile-icon {
    width: 40px;
    height: 40px;
}
button.search {
  background-color: #a590c7 !important;
}

</style>
