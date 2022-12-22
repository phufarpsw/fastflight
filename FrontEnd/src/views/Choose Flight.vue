<template>
  <div id="app" class="relative min-h-screen">
    <!-- <SignUp v-show="openRegister" />
    <Login v-show="openLogin" /> -->
    <Navbar />

    <div class="w-full mt-10 h-4/5 flex justify-center items-center">
      <div class="
          flex
          justfiy-center
          items-center
        ">
        <div class="flex">
          <div class="bg-white rounded-lg px-6">
            <div class="mb-8">
              <div class="py-6">
                <p class="justify-self-center self-center font-medium topic-font text-2xl mb-2 font-medium">
                  Depature flight to {{ where }}</p>
                <p class="justify-self-center self-center font-medium topic-font text-lg text-slate-500">{{ this.date_from }} | {{ Flights.length }} Travelers</p>
              </div>
              <div v-for="(item, index) in Flights" :key="index"
                class="flight-dropdown flex flex-col justify-center items-center">

                <div class="
                flex
                justify-center
                items-center
                rounded-lg
                p-6
                shadow-lg
              " style="width:1000px">
                  <div class="w-full flex justify-between items-center p-2">
                    <img v-if="Flights[index].airline == 'Thai'" src="../assets/flightlogo.svg" />
                    <img v-else-if="Flights[index].airline == 'Lion'" src="../assets/Lionairline.svg" />
                    <img v-else-if="Flights[index].airline == 'AirAsia'" src="../assets/koreaAirline.svg" />
                    <img v-else-if="Flights[index].airline == 'NokAir'" src="../assets/scoot-air.svg" />

                    <div class="ml-6 flex justify-center items-center">
                      <div class="ml-4">
                        <p>{{ item.goFlight.slice(0, 6) }}</p>
                        <p>BKK</p>
                      </div>
                      <img src="../assets/plane555.svg" class="ml-4" />
                      <div class="ml-4">
                        <p>{{ item.returnFlight.slice(0, 6) }}</p>
                        <p>{{ item.to.slice(0, 3).toUpperCase() }}</p>
                      </div>
                      <div class="ml-4">
                        <p>15h 5m</p>
                        <p>Transit</p>
                      </div>
                      <p class="ml-12">฿ {{ item.price }} /pax</p>
                    </div>
                    <div class="flex justify-center items-center space-x-6">
                      <button type="submit" :id="'btnChoose' + index" @click="chooseFlight(index)" class="
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
              ">
                        CHOOSE FLIGHT
                      </button>
                      <img @click="clickSlide(index)" :id="'imgArrow' + index" src="../assets/arrowDown.svg" alt="">
                    </div>
                  </div>
                </div>
                <!-- DropDown -->
                <div :id="'dropdown-items' + index"
                  class="dropdown-set flex justify-between items-center border rounded-lg px-6 py-12"
                  style="width:1000px">
                  <div class="ml-4">
                    <p class="text-2xl font-bold" style="color : #525197">{{ item.airlineID }}</p>
                    <p class="text-slate-500">Flight</p>
                  </div>
                  <img src="../assets/PLANELINE.svg" class="ml-8" />
                  <div class="ml-8">
                    <div class="flex">
                      <div class="ml-4">
                        <p class="text-lg font-bold">{{ item.goFlight.slice(0,6) }}</p>
                        <p class="text-slate-500">{{ date_from.slice(10) }}</p>
                      </div>
                      <div class="ml-12">
                        <p class="font-bold">Bangkok (BKK)</p>
                        <p class="text-slate-500">Suvarnabhumi Airport</p>
                      </div>
                    </div>
                    <div class="flex ml-4 my-6">
                      <img src="../assets/clock.svg" class="mr-2" />
                      <p class="text-slate-500">2h 5m</p>
                    </div>
                    <div class="flex">
                      <div class="ml-4">
                        <p class="text-lg font-bold">{{ item.returnFlight.slice(0, 6) }}</p>
                        <p class="text-slate-500">{{ date_to[index] }}</p>
                      </div>
                      <div class="ml-12">
                        <p class="font-bold">Tokyo (NRT)</p>
                        <p class="text-slate-500">{{ item.to }}</p>
                      </div>
                    </div>
                  </div>
                  <div class="ml-12">
                    <div class="flex">
                      <img src="../assets/nonrefund.svg" class="mr-4" />
                      <p class="text-slate-500">Non Refundable</p>
                    </div>
                    <div class="flex">
                      <img src="../assets/nonresche.svg" class="mr-4" />
                      <p class="text-slate-500">Non Reschedulable</p>
                    </div>
                    <div class="flex">
                      <img src="../assets/cabinbaggage.svg" class="mr-4" />
                      <p class="text-slate-700">Cabbin baggage 10 KG</p>
                    </div>
                    <div class="flex">
                      <img src="../assets/baggage.svg" class="mr-4" />
                      <p class="text-slate-700">Baggage 25 KG</p>
                    </div>
                    <div class="flex">
                      <img src="../assets/entertainment.svg" class="mr-4" />
                      <p class="text-slate-700">Entertainment</p>
                    </div>
                  </div>
                </div>
                <!-- Close Dropdown -->

              </div>
              <!-- HERE -->
            </div>

          </div>
        </div>
      </div>
    </div>

  </div>
</template>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
import axios from "axios";
import navbar from "./component/navbar.vue";
import Vue from 'vue';
// import SignUp from "./login/signup.vue";
// import Login from './login/login.vue';
export default {
  name: "choose",
  components: {
    Navbar: navbar,
    // SignUp: SignUp,
    // Login: Login,
    openLogin: false,
    openRegister: false,
    dateFlight: "",
  },
  data(){
    return {
      Flights:JSON.parse(localStorage.getItem("searchFlight")),
      where: localStorage.getItem("toSearch"),
      date_from: JSON.parse(localStorage.getItem('date_from')),
      date_to: JSON.parse(localStorage.getItem("date_to"))
    };
  },
  methods:{
    clickSlide(index){
      let query = "#dropdown-items"+index
      $(query).slideToggle("slow", (e)=> {
      })
    
    },
    chooseFlight(index){
      localStorage.setItem("choose", JSON.stringify(this.Flights[index]))
      this.$router.push('/seat')
      console.log(JSON.stringify(this.Flights[index]))
    }
  },
  mounted(){
    $(".dropdown-set").hide();
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

.font-copper {
  font-family: "Copperplate";
}

.center-img {
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
  background-image: url("../assets/bg.svg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: bottom;
  background-attachment: fixed;
}

#panel,
#flip {
  padding: 5px;
  text-align: center;
  background-color: #e5eecc;
  border: solid 1px #c3c3c3;
}

#panel {
  padding: 50px;
  display: none;
}

.fname {
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
