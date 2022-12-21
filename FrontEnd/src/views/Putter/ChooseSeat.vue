<template>
  <div id="app" class="relative pb-20">
    <SignUp v-show="openRegister" />
    <Login v-show="openLogin" />
    <Navbar />
    <div class="flex justify-center items-center mt-24">
      <div class="
          container-form
          justfiy-center
          items-center
          bg-white
          rounded-lg
        ">
        <div class="border-b py-6 px-7 text-center">
          <div class="">
            <p class="ml-6 justify-self-center self-center font-medium topic-font text-2xl mb-2 font-medium thai-font"
              style="color : #636161">เลือกที่นั่ง</p>
          </div>
        </div>
        <div class="w-full px-12 flex flex-col mt-24 mb-12">
          <div class="image-container">
            <img src="../../assets/airplaneseat.svg" alt="" style="width: 400px" class="ml-auto mr-auto">
            <div class="left-content text-black">
              <div v-for="index in 13" :key="index" class="flex mb-4" v-bind:class="{ 'mb-12': index === 3 }">
                <button class="bg-gray-100 seat font-copper text-gray-500"
                  v-bind:class="{ 'seat-selected': selectedSeat.indexOf('A' + index + ', ') !== -1, 'seat-reserved': reservedSeat.indexOf('A' + index + ', ') !== -1 }"
                  @click="toggleSelectSeat('A' + index)"
                  :disabled="reservedSeat.indexOf('A' + index + ', ') !== -1">A</button>
                <button class="bg-gray-100 seat ml-2 font-copper text-gray-500"
                  v-bind:class="{ 'seat-selected': selectedSeat.indexOf('B' + index + ', ') !== -1, 'seat-reserved': reservedSeat.indexOf('B' + index + ', ') !== -1 }"
                  @click="toggleSelectSeat('B' + index)"
                  :disabled="reservedSeat.indexOf('B' + index + ', ') !== -1">B</button>
                <button class="bg-gray-100 seat ml-2 font-copper text-gray-500"
                  v-bind:class="{ 'seat-selected': selectedSeat.indexOf('C' + index + ', ') !== -1, 'seat-reserved': reservedSeat.indexOf('C' + index + ', ') !== -1 }"
                  @click="toggleSelectSeat('C' + index)"
                  :disabled="reservedSeat.indexOf('C' + index + ', ') !== -1">C</button>
                <p class="self-center font-copper mx-4 num-size">{{ index }}</p>
                <button class="bg-gray-100 seat font-copper text-gray-500"
                  v-bind:class="{ 'seat-selected': selectedSeat.indexOf('D' + index + ', ') !== -1, 'seat-reserved': reservedSeat.indexOf('D' + index + ', ') !== -1 }"
                  @click="toggleSelectSeat('D' + index)"
                  :disabled="reservedSeat.indexOf('D' + index + ', ') !== -1">D</button>
                <button class="bg-gray-100 seat ml-2 font-copper text-gray-500"
                  v-bind:class="{ 'seat-selected': selectedSeat.indexOf('E' + index + ', ') !== -1, 'seat-reserved': reservedSeat.indexOf('E' + index + ', ') !== -1 }"
                  @click="toggleSelectSeat('E' + index)"
                  :disabled="reservedSeat.indexOf('E' + index + ', ') !== -1">E</button>
                <button class="bg-gray-100 seat ml-2 font-copper text-gray-500"
                  v-bind:class="{ 'seat-selected': selectedSeat.indexOf('F' + index + ', ') !== -1, 'seat-reserved': reservedSeat.indexOf('F' + index + ', ') !== -1 }"
                  @click="toggleSelectSeat('F' + index)"
                  :disabled="reservedSeat.indexOf('F' + index + ', ') !== -1">F</button>
              </div>
            </div>

          </div>
          <div class="mt-20 border p-8 rounded-md border-4" style="border-color : #F1E8FF">
            <div class="flex">
              <div class="fly-to">
                <div class="flex">
                  <p class="thai-font text-2xl">BKK</p>
                  <img src="../../assets/seatplanelogo.svg" alt="" style="margin-left : 37px">
                  <p class="thai-font text-2xl" style="margin-left : 57px">{{ this.whereTo.slice(0, 3).toUpperCase() }}</p>
                </div>
                <div class="">
                  <img src="../../assets/seatplanefly.svg" alt="">
                </div>
              </div>
              <div class="seatnum ml-24">
                <p class="thai-font text-lg text-gray-400">ที่นั่ง</p>
                <p class="thai-font text-lg text-seat">{{ selectedSeat }}</p>
              </div>
              <div class="price ml-20">
                <p class="thai-font text-lg text-gray-400">ราคา</p>
                <p class="thai-font text-lg">{{ price }}</p>
              </div>
            </div>
          </div>
          <button @click="clickToContinue()" class="mt-12 py-4 text-white rounded-lg font-thai text-lg font-copper"
            style="background-color : #A590C7">CONTINUE</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import navbar from "../component/navbar.vue";
import SignUp from "../login/signup.vue";
import Login from '../login/login.vue';
import Vue from 'vue';
export default {
  name: "seat",
  components: {
    Navbar: navbar,
    SignUp: SignUp,
    Login: Login,

  },
  data() {
    return {
      user: JSON.parse(localStorage.getItem("passenger")),
      choose: JSON.parse(localStorage.getItem("choose")),
      reservedSeat: "A1, B1, F11, C12, D13, B8, E3, D7, B5, E6 , F7",
      selectedSeat: "",
      price: 0,
      whereTo: JSON.parse(localStorage.getItem("choose")).to,
      priceFlight: JSON.parse(localStorage.getItem("choose")).price,
      number: JSON.parse(localStorage.getItem("numOfPassenger")),
      countCheck: 0
    };
  },
  methods: {
    toggleSelectSeat(item) {

      if (this.selectedSeat.indexOf(item + ", ") === -1) {
        this.selectedSeat += (item + ", ");
        this.price += this.priceFlight;
        this.countCheck++
      } else {
        this.selectedSeat = this.selectedSeat.replace(item + ', ', '');
        this.price -= this.priceFlight;
        this.countCheck--;
      }
    },
    clickToContinue() {
      if (this.countCheck == parseInt(this.number)) {
        let reserve = {
          "username": this.user.username,
          "fullName": this.user.firstName + " " + this.user.lastName,
          "from": "Bangkok - Suvarnabhumi",
          "to": this.choose.to,
          "airline": this.choose.airline,
          "airlineID": this.choose.airlineID,
          "planeName": this.choose.planeName,
          "goFlight": this.choose.goFlight,
          "returnFlight": this.choose.returnFlight,
          "seat": this.selectedSeat.slice(0,-2),
          "price": this.choose.price

        }
        localStorage.setItem("reserve", JSON.stringify(reserve))
        this.$router.push('/detail')
      }
      else {
        alert("Please Select Again")
      }
    }
  },
  mounted() {
    if (JSON.parse(localStorage.getItem("passenger")) == null) {
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
  background-image: url("../../assets/bg.svg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: bottom;
  background-attachment: fixed;
}

.seat-selected {
  background-color: #DCC7FF;
}

.seat-reserved {
  color: #D9D9D9;
  background-color: #D9D9D9;
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
