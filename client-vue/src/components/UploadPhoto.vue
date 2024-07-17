<script setup>
import {ref} from "vue";

const uploadImages = ref([]);

async function convertIntoURL(imageFile) {
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

async function upload() {
  const imageFile = uploadImages.value[0];
  if (imageFile === null) {
    return;
  }
  const name = imageFile.name;
  const url = await convertIntoURL(imageFile);
  const [header, base64] = url.split(",");

  await window.fetch("/api/images", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({name, header, base64})
  });
}
</script>

<template>
  <h2>画像を追加する</h2>
  <v-file-input
      variant="underlined"
      clearable
      label="画像を添付する"
      accept="image/*"
      v-model="uploadImages"
  />
  <v-btn @click="upload">送信する</v-btn>
</template>

<style scoped>
</style>