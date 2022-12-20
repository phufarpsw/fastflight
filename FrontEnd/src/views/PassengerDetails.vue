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
      <div class="border-b p-4">
                <p class="text-center">ข้อมูลการติดต่อ</p>
            </div>
        <div class="w-full px-12 flex flex-col my-6">
          <form action="" class="w-full space-y-6">
            <!-- TextField flight -->
            <div class="flight w-full flex justify-between">
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/prename.png" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="ชื่อจริง"
                    type="text"
                  />
                </label>
              </div>

              <!-- <img
                class="w-8 absolute"
                src="../../src/assets/flight-change.svg"
                alt=""
              /> -->
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/prename.png" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="นามสกุล"
                    type="text"
                  />
                </label>
              </div>
            </div>
            <!-- Passenger Field -->
            <div class="psg w-full flex justify-between">
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/thaiflag.png" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="หมายเลขโทรศัพท์มือถือ"
                    type="text"
                  />
                </label>
              </div>
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/envelope.png" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="อีเมล"
                    type="text"
                  />
                </label>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- Section 2  -->
    <div class="flex justify-center mt-12">
      <div
        class="
          container-form
          justfiy-center
          items-center
          bg-white
          rounded-lg
        "
      >
      <div class="border-b p-4">
                <p class="text-center">ข้อมูลผู้เดินทาง</p>
            </div>
        <div class="w-full px-12 flex flex-col my-6">
          <form action="" class="w-full space-y-6">
            <!-- TextField flight -->
            <div class="flight w-full flex justify-between">
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/prename.png" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="ชื่อจริง"
                    type="text"
                  />
                </label>
              </div>


              <!-- <img
                class="w-8 absolute"
                src="../../src/assets/flight-change.svg"
                alt=""
              /> -->
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/prename.png" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="นามสกุล"
                    type="text"
                  />
                </label>
              </div>
            </div>
            <!-- TextField flight -->
            <div class="flight w-full flex justify-between">
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/bornat.svg" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="วันเดือนปีเกิด"
                    type="text"
                  />
                </label>
              </div>


              <!-- <img
                class="w-8 absolute"
                src="../../src/assets/flight-change.svg"
                alt=""
              /> -->
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/earth.svg" alt="" style="width : 30px"/>
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="สัญชาติ"
                    type="text"
                  />
                </label>
              </div>
            </div>
            <!-- Passenger Field -->
            <div class="psg w-full flex justify-between">
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../assets/passportnumber.svg" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="หมายเลขหนังสือเดินทาง"
                    type="text"
                  />
                </label>
              </div>
              <div>
                <label class="relative block" style="width: 335px">
                  <span
                    class="
                      absolute
                      inset-y-0
                      left-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    "
                  >
                    <img src="../../src/assets/visacountry.svg" alt="" />
                  </span>
                  <input
                    class="
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
                    "
                    placeholder="ประเทศที่ออกหนังสือเดินทาง"
                    type="text"
                  />
                </label>
              </div>
            </div>
            <div class="w-full">
              <template  class="date-input w-full" >
                <div v-on="inputEvents">
              <label class="relative block">
                <span
                  justify-center
                  class="absolute inset-y-0 left-0 flex items-center pl-2"
                >
                  <img src="../../src/assets/calendar.svg" alt="" />
                </span>
                <input
                  class="
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
                  "
                  placeholder="วันหมดอายุหนังสือเดินทาง"
                  type="text"
                  style="cursor: default;"
                  readonly
                />
              </label>
            </div>
              </template>
            </div>
            <button
              type="submit"
              class="
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
              "
            >
              CONTINUE
            </button>
          </form>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import navbar from "./component/navbar.vue";
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
  color: #817a7a !important;
  font-family: "Prompt", sans-serif;
}

#app {
  background-color: #dbdaff;
  background-image: url("../assets/mountain-bg.png");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: bottom;
  background-attachment: fixed;
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
