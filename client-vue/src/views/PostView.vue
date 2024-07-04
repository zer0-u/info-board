<script setup>
import {ref} from "vue";

const form = ref();
const title = ref("");
const author = ref("");
const content = ref("");

const notEmptyRule = [
  value => {
    return value ? true : "必須入力です";
  }
];

const reset = () => {
  form.value.reset();
};

const submit = async () => {
  const {valid} = await form.value.validate();
  if (!valid) {
    return;
  }
  await window.fetch('/api/articles', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      title: title.value,
      author: author.value,
      content: content.value
    })
  });
  reset();
}


</script>

<template>
  <h1>お知らせを投稿する</h1>

  <v-form ref="form">
    <v-text-field variant="outlined" :rules="notEmptyRule" label="タイトル" v-model="title"/>
    <v-text-field variant="outlined" :rules="notEmptyRule" label="投稿者名" v-model="author"/>
    <v-textarea variant="outlined" :rules="notEmptyRule" label="本文" v-model="content"/>
    <v-btn variant="outlined" @click="submit">投稿する</v-btn>
    <v-btn variant="outlined" @click="reset">リセットする</v-btn>
  </v-form>
</template>

<style scoped>

</style>