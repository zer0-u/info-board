<script setup>

import Article from "@/components/Article.vue";
import {onMounted, ref} from "vue";

const articles = ref([]);

const fetchMessage = async () => {
  try {
    const response = await window.fetch("/api/articles");
    articles.value = await response.json();
  } catch (error) {
    console.log(error);
  }
};

onMounted(() => {
  fetchMessage()
});
</script>

<template>
  <h1>お知らせ一覧</h1>
  <v-list lines="three" v-for="article of articles">
    <Article v-bind:article/>
  </v-list>
</template>

<style scoped>

</style>