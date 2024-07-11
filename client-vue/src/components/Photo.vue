<script setup>
const props = defineProps({
  image: Object
})

</script>

<template>
  <div class="base">
    <img :src="`${image.schema},${image.image}`" :alt="image.name"/>
  </div>

</template>

<style scoped>
.base {
  background-color: #2c3e50;
}

img {
  width: 50%;
}
</style>