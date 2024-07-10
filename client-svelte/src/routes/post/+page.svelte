<script>
    export let form;
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
    <button formaction="?/create">投稿する</button>
    <button formaction="?/reset">リセットする</button>
</form>

<style>
    .error {
        color: darkred;
        font-size: 0.8rem;
    }
</style>