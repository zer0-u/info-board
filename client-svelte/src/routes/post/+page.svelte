<script>
    export let form;
    let imageFiles = [];
    let base64Images = [];

    async function readAsDataURL(imageFile) {
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

    async function encodeImageFiles() {
        base64Images = await Promise.all(Array.from(imageFiles).map(async imageFile => {
            const name = imageFile.name;
            const [header, base64] = (await readAsDataURL(imageFile)).split(',');
            return {name, header, base64};
        }));
        console.log(base64Images);
    }

</script>

<h1>お知らせを投稿する</h1>

<form method="POST">
    <p>
        <label>
            タイトル
            <input type="text" size="40" name="title" autocomplete="off" value={form?.title.value ?? ''}/>
            {#if form}
                <p class="error">
                    {#each form.title.errors as error}
                        <span>{error}</span>
                    {/each}
                </p>
            {/if}
        </label>
    </p>
    <p>
        <label>
            投稿者名
            <input type="text" size="40" name="author" autocomplete="off" value={form?.author.value ?? ''}/>
            {#if form}
                <p class="error">
                    {#each form.author.errors as error}
                        <span>{error}</span>
                    {/each}
                </p>
            {/if}
        </label>
    </p>
    <p>
        <textarea placeholder="本文" cols="60" rows="10" name="content"
                  autocomplete="off" value={form?.content.value ?? ''}/>
        {#if form}
            <p class="error">
                {#each form.content.errors as error}
                    <span>{error}</span>
                {/each}
            </p>
        {/if}
    </p>
    <p>
        <input type="file" accept="image/*" name="imageFiles" multiple bind:files={imageFiles}
               on:change={encodeImageFiles}/>
    </p>
    <ul>
        {#each imageFiles as imageFile}
            <li>{imageFile.name}</li>
        {/each}
    </ul>
    <button formaction="?/create">投稿する</button>
    <button formaction="?/reset">リセットする</button>
</form>

<style>
    .error {
        color: darkred;
        font-size: 0.8rem;
    }
</style>