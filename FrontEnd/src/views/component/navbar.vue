<template>
  <div id="id" class="relative">
    <nav class="flex relative select-none justify-between px-12 py-4">
      <div class="logo flex w-1/3 justfiy-center space-x-2 items-center">
        <img src="../../assets/logo.png" alt="" />
        <p class="text-lg">FASTFLIGHT</p>
      </div>
      <div class="group-menubar text-sm w-1/3 flex justify-between items-center">
        <p>HOME</p>
        <p>FLIGHT</p>
        <p>PROMO</p>
      </div>
      <div class="login flex w-1/3 justify-end items-center ">
        <p>LOGIN</p>
      </div>
    </nav>
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Prompt&display=swap');
@font-face {
  font-family: "Copperplate";
  src: url(../../../public/fonts/Copperplate\ Gothic\ Bold\ Regular.ttf);
}
nav {
  border-bottom: 1px solid #525197;
}
nav>div>p{
    font-family: "Copperplate";
}
</style>
