<template>
  <div id="app" class="relative h-screen">
    <SignUp v-show="openRegister" />
    <Login v-show="openLogin" />
    <Navbar />
    <div class="h-4/5 flex justify-center items-center">
      <div class="
          container-form
          py-12
          flex
          justfiy-center
          items-center
          bg-white
          rounded-lg
        ">
        <div class="w-full px-12 flex flex-col">
          <form action="" class="w-full space-y-6">
            <div class="radio-button flex space-x-6">
              <div class="space-x-2">
                <input type="radio" name="type_travel" checked v-model="flightMode" value="multiple" />
                <label for="" class="font-medium thai-font" style="color: #817a7a">การเดินทาง-ไปกลับ</label>
              </div>
              <div class="space-x-2">
                <input type="radio" name="type_travel" v-model="flightMode" value="oneflight" />
                <label for="" class="font-medium thai-font" style="color: #817a7a">เดินทางเที่ยวเดียว</label>
              </div>
            </div>
            <!-- TextField flight -->
            <div class="flight w-full flex justify-between">
              <div>
                <label class="relative block" style="width: 335px">
                  <span class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                      z-10
                    ">
                    <img src="../../src/assets/plane-up.svg" alt="" />
                  </span>
                  
                  <input class="
                      w-full
                      thai-font
                      text-sm
                      placeholder-gray-400
                      bg-gray-100
                      border border-slate-300
                      rounded-md
                      py-2.5
                      pl-12
                      pr-4
                      focus:outline-none
                      peer
                    " placeholder="เลือกเมืองสำหรับเที่ยวบินขาไป" type="text" value="Bangkok - Suvarnabhumi" disabled/>
                </label>
              </div>

              <!-- <img
                class="w-8 absolute"
                src="../../src/assets/flight-change.svg"
                alt=""
              /> -->
              <div>
                <label class="relative block" style="width: 335px">
                  <span class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    ">
                    <img src="../../src/assets/plane-down.svg" alt="" />
                  </span>
                  <v-select :options="books" class=""  label="selected" outlined>
                  </v-select>
                  <!-- <input class="
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
                    " placeholder="เลือกเมืองปลายทาง" type="text" /> -->
                </label>
              </div>
            </div>
            <!-- One Flight -->
            <div class="w-full" v-show="flightMode === 'oneflight'">
              <DatePicker v-model="goDate" :attributes="attrs" color="indigo" locale="th"
                :model-config="{ type: 'string', mask: 'MM/DD/YYYY' }">
                <template v-slot="{ inputEvents }" class="date-input w-full">
                  <div v-on="inputEvents">
                    <label class="relative block">
                      <span justify-center class="absolute inset-y-0 left-0 flex items-center pl-2">
                        <img src="../../src/assets/calendar.svg" alt="" />
                      </span>
                      <input class="
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
                  " placeholder="วันที่ออกเดินทาง" type="text" v-model="goDate" style="cursor: default;" readonly />
                    </label>
                  </div>
                </template>
              </DatePicker>
            </div>
            <!-- Multiple Flight -->
            <div class="flight w-full flex justify-between" v-show="flightMode === 'multiple'">
              <DatePicker :columns="2" v-model="range" is-range :attributes="attrs" color="indigo" locale="th"
                :model-config="{ type: 'string', mask: 'MM/DD/YYYY' }">
                <template v-slot="{ inputEvents }">
                  <div v-on="inputEvents.start">
                    <label class="relative block" style="width: 335px">
                      <span justify-center class="absolute inset-y-0 left-0 flex items-center pl-2">
                        <img src="../../src/assets/calendar.svg" alt="" />
                      </span>
                      <input class="
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
                  " placeholder="วันที่ออกเดินทาง" type="text" v-model="range.start" style="cursor: default;"
                        readonly />
                    </label>
                  </div>
                </template>
              </DatePicker>

              <DatePicker :columns="2" v-model="range" is-range :attributes="attrs" color="indigo" locale="th"
                :model-config="{ type: 'string', mask: 'MM/DD/YYYY' }">
                <template v-slot="{ inputEvents }">
                  <div v-on="inputEvents.start">
                    <label class="relative block" style="width: 335px">
                      <span justify-center class="absolute inset-y-0 left-0 flex items-center pl-2">
                        <img src="../../src/assets/calendar.svg" alt="" />
                      </span>
                      <input class="
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
                  " required placeholder="วันเดินทางกลับ" type="text" v-model="range.end" style="cursor: default;"
                        readonly />
                    </label>
                  </div>
                </template>
              </DatePicker>
            </div>
            <!-- Passenger Field -->
            <div class="psg w-full flex justify-between">
              <div>
                <label class="relative block" style="width: 335px">
                  <span class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    ">
                    <img src="../../src/assets/passenger.svg" alt="" />
                  </span>
                  <input class="
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
                    " placeholder="จำนวนผู้โดยสาร" type="text" />
                </label>
              </div>
              <!-- Select Class -->
              <div class="flex justify-center">
                <div class="relative" style="width: 335px">
                  <span class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    ">
                    <img src="../../src/assets/seat.svg" alt="" />
                  </span>
                  <select class="
                      seat-select
                      appearance-none
                      thai-font
                      block
                      w-full
                      py-2.5
                      pl-12
                      pr-4
                      text-sm
                      border border-slate-300
                      rounded-md
                      transition
                      ease-in-out
                      focus:text-gray-200
                      focus:bg-white
                      focus:border-purple-600
                      focus:outline-none

                    " required>
                    <option selected disabled class="bg-gray-200">
                      ระดับชั้นการเดินทาง
                    </option>
                    <option value="1" class="hover:bg-red-200">ชั้นประหยัด</option>
                    <option value="2">ชั้นประหยัดพรีเมียม</option>
                    <option value="3">ชั้นธุรกิจ</option>
                    <option value="4">ชั้นหนึ่ง</option>
                  </select>
                </div>
              </div>
            </div>
            <button @click="findFlight()" type="submit" class="
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
              SEARCH
              <!-- <svg aria-hidden="true" class="ml-2 -mr-1 w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg> -->
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
import axios from "axios";
import navbar from "./component/navbar.vue";
import SignUp from "./login/signup.vue";
import Login from './login/login.vue';
import DatePicker from 'v-calendar/lib/components/date-picker.umd'
import 'vue-select/dist/vue-select.css';
Vue.component('date-picker', DatePicker)

export default {
  name: "Home",
  data() {
    return {
      goingTo: "",
      dateFrom: "",
      dateTo:"",
      openLogin: false,
      openRegister: false,
      flightMode: "multiple",
      goDate: null,
      books: [
        "Old Man's War" ,
        "The Lock Artist",
        "HTML5",
        "Right Ho Jeeves",
        "The Code of the Wooster",
        "Thank You Jeeves"
      ],
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
    }
  },
  components: {
    Navbar: navbar,
    SignUp: SignUp,
    Login: Login,
    DatePicker,
  },
  methods: {
    findFlight() {
      let flight = {
        "from": "Bangkok - Suvarnabhumi",
        "to": this.goingTo,
        "dateFrom": this.dateFrom,
        "dateTo": this.dateTo
      }
      axios.post("http://localhost:9002/flights/getFlightWithTo", flight)
                .then((res) => {
                    if (res.data._id != []) {  
                        alert(res.data.length);
                    }
                    else {
                        alert("POST Failed");
                    }
                }).catch(err => {
                    console.log(err);
                })
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

.thai-font {
  color: #817a7a !important;
  font-family: "Prompt", sans-serif;
}

#app {
  background-color: #dbdaff;
  background-image: url("../assets/mountains-5972713\ 1.svg");
  background-size: contain;
  background-repeat: no-repeat;
  background-position: bottom;
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
