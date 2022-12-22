<template>
  <div id="app" class="relative min-h-screen">
    <Navbar />
    <div class="mt-14 flex justify-center items-center">
      <div class="
          flex
          justify-center
          items-center
          bg-white
          rounded-lg
        ">
        <div class="w-full flex rounded-lg">
          <div class="h-48 lg:h-auto w-48 bg-cover rounded-md text-center justify-center py-5"
            style="background-color : #6765AA">
            <img src="../../assets/fakeprofile.png" alt="" style="width: 90px" class="center-img" />
            <p class="topic-font mt-1" style="color: white">Welcome, {{ this.name }}</p>
            <div @click="deleteSession()" class="cursor-pointer flex justify-center items-end h-48 font-copper">
              <img src="../../assets/logout.png" width="27" alt="" />
              <p class="ml-3 font-copper" style="color: white">LOGOUT</p>
            </div>
          </div>
          <div class="">
            <div class="">
              <div class="flex border-b border-gray-200 py-3 justify-between px-6">
                <div class="flex">
                  <img src="../../assets/profile.svg" alt="" style="width:40px" class="ml-4" />
                  <p class="ml-6 justify-self-center self-center font-medium topic-font">Profile</p>
                </div>
                <p class="ml-6 justify-self-center self-center font-medium topic-font mr-4" style="color : #A590C7">EDIT
                </p>
              </div>
              <!-- Form -->
              <div class="space-y-4 pt-10 pb-10">
                <div class="flex justify-center items-center px-12">
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
                    " placeholder="ชื่อจริง" v-model="firstname" type="text" />
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
                    " placeholder="นามสกุล" v-model="lastname" type="text" />
                          </label>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
                <div class="
          flex
          justify-center
          items-center
          rounded-lg
        " style="width:800px">
                  <div class="justify-center flex">
                    <form action="" class="space-y-6">
                      <div class="flex space-x-8 justify-between">
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
                    " placeholder="เบอร์โทรศัพท์" v-model="telephone" type="text" />
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
                    " placeholder="อีเมล" v-model="emails" type="text" />
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
                  " placeholder="เลขบัตรประชาชน" v-model="citizen" type="text" />
                            </label>
                          </div>
                        </template>
                      </div>
                    </form>
                  </div>
                </div>
                <div class="flex justify-end mr-12">
                  <button @click="EditPassenger()" class="px-12 py-2 text-white rounded-lg text-md font-copper"
                    style="background-color : #A590C7">SAVE</button>
                </div>
              </div>
              <!-- End -->
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
  name: "edit",
  components: {
    Navbar: navbar,
  },
  data() {
    return {
      passenger: JSON.parse(localStorage.getItem("passenger")),
      name: JSON.parse(localStorage.getItem("passenger")).firstName,
      firstname : "",
      lastname : "",
      citizen : "",
      emails : "",
      telephone : "",
    };
  },
  methods:{
    deleteSession(){
      localStorage.removeItem("passenger")
      location.reload()
    },
    EditPassenger(){
      let data = {
        "_id" : this.passenger._id,
        "username" : this.passenger.username,
        "password" : this.passenger.password,
        "firstName": this.firstname,
        "lastName": this.lastname,
        "idCardNumber": this.citizen,
        "email": this.emails,
        "tel": this.telephone
      }
      axios.post("http://localhost:9001/passengers/updatePassenger", data)
        .then((res) => {
          if (res.data == "Update Successful"){
            alert("Passenger has been edited")
            location.reload()
          }
          else{
            alert("Edit Failed")
          }
        })

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
