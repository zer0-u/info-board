<script setup>
import {ref} from "vue";

const form = ref();
const title = ref("");
const author = ref("");
const content = ref("");
const completed = ref(false);
const imageFiles = ref([]);

const notEmptyRule = [
  value => {
    return value ? true : "必須入力です";
  }
];

const reset = () => {
  form.value.reset();
  completed.value = false;
};

const readAsDataURL = async imageFile => {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.readAsDataURL(imageFile);
    reader.onload = (event) => {
      resolve(event.target.result);
    };
    reader.onerror = (event) => {
      reject(new Error("画像の読み込みに失敗しました"));
    };
  });
}

const encodeImageFilesToBase64 = async () => {
  return await Promise.all(imageFiles.value.map(async imageFile => {
    const name = imageFile.name;
    const url = await readAsDataURL(imageFile);
    const [header, base64] = url.split(',');
    return {name, header, base64};
  }));
}

const submit = async () => {
  const {valid} = await form.value.validate();
  if (!valid) {
    return;
  }
  const images = await encodeImageFilesToBase64();
  await window.fetch('/api/articles', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      title: title.value,
      author: author.value,
      content: content.value,
      images: images,
    })
  });
  completed.value = true;
  reset();
}


</script>

<template>
  <h1>お知らせを投稿する</h1>
  <v-form ref="form">
    <v-text-field variant="outlined" :rules="notEmptyRule" label="タイトル" v-model="title"/>
    <v-text-field variant="outlined" :rules="notEmptyRule" label="投稿者名" v-model="author"/>
    <v-textarea variant="outlined" :rules="notEmptyRule" label="本文" v-model="content"/>
    <v-file-input
        variant="outlined"
        prepend-icon="mdi-camera"
        chips
        clearable
        multiple
        label="添付画像"
        accept="image/*"
        v-model="imageFiles"
    />
    <v-btn variant="outlined" @click="submit">投稿する</v-btn>
    <v-btn variant="outlined" @click="reset">リセットする</v-btn>
  </v-form>

  <v-snackbar v-model="completed" :timeout="3000">投稿しました</v-snackbar>
</template>

<style scoped>

</style>