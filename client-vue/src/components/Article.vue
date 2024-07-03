<script setup>
const props = defineProps({
  article:Object
});

</script>

<template>
  <h2>{{ article.title }}</h2>
  <div class="author">
    <p>{{ article.createdAt }}</p>
    <p>{{ article.author }}</p>
  </div>
  <main>
    {{ article.content }}
  </main>
</template>

<style scoped>
.author {
  color: darkgray;
}
</style>