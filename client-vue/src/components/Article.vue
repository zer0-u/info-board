<script setup>
const article = {
  title: 'タイトル',
  date: 'YYYY/MM/DD',
  author: '投稿した人',
  content: 'これは本文です',
};
</script>

<template>
  <h2>{{ article.title }}</h2>
  <div class="author">
    <p>{{ article.date }}</p>
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