<template>
  <div id="app">
    <div class="flex justify-center">
      <div class="relative mb-3 xl:w-96">
        <span
          class="absolute inset-y-0 left-0 flex justify-center items-center pl-2"
        >
          <img src="../../src/assets/plane-up.svg" alt="" />
        </span>
        <select
          class="form-select appearance-none
      block
      w-full
      px-3
      py-1.5
      text-base
      font-normal
      text-gray-700
      bg-white bg-clip-padding bg-no-repeat
      border border-solid border-gray-300
      rounded
      transition
      ease-in-out
      m-0
      focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
          aria-label="Default select example"
        >
          <option selected disabled value="0" class="bg-gray-200"
            >ระดับชั้นการเดินทาง</option
          >
          <option value="1">ชั้นประหยัด</option>
          <option value="2">ชั้นประหยัดพรีเมียม</option>
          <option value="3">ชั้นธุรกิจ</option>
          <option value="4">ชั้นหนึ่ง</option>
        </select>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Test"
};
</script>
<style></style>
