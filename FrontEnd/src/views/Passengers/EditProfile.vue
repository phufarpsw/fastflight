<template>
  <div id="app" class="relative min-h-screen">
    <Navbar />
    <div class="h-4/5 flex justify-center items-center">
      <div class="
          flex
          justfiy-center
          items-center
          bg-white
          rounded-lg
        ">
        <div class="w-full flex rounded-lg">
          <div
            class="h-48 lg:h-auto lg:w-48 flex-none bg-cover rounded-t lg:rounded-t-none lg:rounded-l text-center overflow-hidden justify-center py-5"
            style="background-color : #6765AA">
            <img src="../../assets/fakeprofile.png" alt="" style="width: 90px" class="center-img" />
            <p class="topic-font mt-1" style="color: white">Welcome, Name</p>
            <div class="justify-self-center">
              <div class="flex mt-52 center-img justify-center">
                <img src="../../assets/logout.png" alt="" style="width:20px" class="" />
                <p class="ml-3 justify-self-center self-center topic-font" style="color: white">LOGOUT</p>
              </div>
            </div>
          </div>
          <div  
            class="justify-between">
            <div class="mb-8">
              <div class="flex border-b border-gray-200 py-3 justify-between">
                <div class="flex">
                  <img src="../../assets/profile.svg" alt="" style="width:40px" class="ml-4" />
                  <p class="ml-6 justify-self-center self-center font-medium topic-font">Profile</p>
                </div>
                <p class="ml-6 justify-self-center self-center font-medium topic-font mr-4" style="color : #A590C7">EDIT
                </p>
              </div>
              <!-- Form -->
              <div class="
          flex
          justify-center
          items-center
          p-10
        ">
        <!-- Row 1 -->
                <div class="w-full justify-center flex">
                  <form action="" class="w-full space-y-6">
                    <div class="w-full flex justify-between">
                      <div class="">
                        <label class="relative block" style="width: 335px">
                          <span class="
                      absolute
                      inset-y-0
                      flex
                      justify-center
                      items-center
                      pl-2
                    ">
                            <img src="../../assets/prename.png" alt="" />
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
                      peer
                    " placeholder="ชื่อจริง" type="text" />
                        </label>
                      </div>
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
                            <img src="../../assets/prename.png" alt="" />
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
                    " placeholder="นามสกุล" type="text" />
                        </label>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
              <div class="
          container-form
          flex
          justify-center
          items-center
          rounded-lg
        ">
                <div class="justify-center flex">
                  <form action="" class="space-y-6">
                    <div class="flex justify-between">
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
                            <img src="../../assets/thaiflag.png" alt="" style="width: 30px" />
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
                      peer
                    " placeholder="เบอร์โทรศัพท์" type="text" />
                        </label>
                      </div>
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
                            <img src="../../assets/envelope.png" alt="" />
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
                    " placeholder="อีเมล" type="text" />
                        </label>
                      </div>
                    </div>
                    <!-- One flight -->
                    <div class="w-full">
                      <template class="date-input w-full">
                        <div>
                          <label class="relative block">
                            <span justify-center class="absolute inset-y-0 left-0 flex items-center pl-2">
                              <img src="../../assets/visa.png" alt="" />
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
                  " placeholder="เลขที่หนังสือเดินทาง" type="text" />
                          </label>
                        </div>
                      </template>
                    </div>
                  </form>
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
  data() {
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
  background-image: url("../../assets/bg.svg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: bottom;
}

.container-form {
  width: 800px;
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
</style>
