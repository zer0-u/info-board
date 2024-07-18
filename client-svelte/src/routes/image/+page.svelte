<script>
    export let data;
    let files;

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

    async function post() {
        if (!files) {
            return;
        }
        const imageFile = files[0];
        const name = imageFile.name;
        const url = await convertIntoURL(imageFile);
        const [header, base64] = url.split(',');
        await window.fetch("/api/images", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({name, header, base64})
        });
    }
</script>

<h1>画像テスト</h1>
<div>
    <h2>写真を投稿する</h2>
    <input type="file" accept="image/*" name="photo" bind:files/>
    <button on:click={post}>投稿する</button>
</div>
<div class="base">
    <h2>ギャラリー</h2>
    {#each data.images as image}
        <img src={`${image.header},${image.base64}`} alt={image.name}/>
    {/each}
</div>


<style>
    .base {
        background-color: #2c3e50;
    }

    img {
        width: 50%;
    }
</style>