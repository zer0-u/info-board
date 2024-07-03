<script setup>
const props = defineProps({
  article: Object
});

</script>

<template>
  <v-card variant="outlined">
    <v-card-title>{{ article.title }}</v-card-title>
    <v-card-subtitle>
      <p>{{ article.author }}</p>
      <p>{{ article.createdAt }}</p>
    </v-card-subtitle>
    <v-card-text>{{ article.content }}</v-card-text>
  </v-card>
</template>

<style scoped>

</style>