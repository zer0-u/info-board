<script setup>

import {onMounted, ref} from "vue";
import Photo from "@/components/Photo.vue";

const images = ref([]);

onMounted((async () => {
  try {
    const response = await window.fetch("/api/images");
    images.value = await response.json();
  } catch (error) {
    console.log(error);
  }
}));
</script>

<template>
  <h1>画像テスト</h1>
  <div v-for="image of images">
    <Photo :image/>
  </div>
</template>

<style scoped>

</style>