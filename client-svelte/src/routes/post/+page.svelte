<script>
    let title = '';
    let author = '';
    let content = '';

    function reset() {
        title = '';
        author = '';
        content = '';
    }

    async function submit() {
        const article = {
            title, author, content
        }
        await window.fetch('/api/articles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(article)
        });
        reset();
    }
</script>

<h1>お知らせを投稿する</h1>
<form>
    <p>
        <label>
            タイトル
            <input type="text" size="40" bind:value={title}/>
        </label>
    </p>
    <p>
        <label>
            投稿者名
            <input type="text" size="40" bind:value={author}/>
        </label>
    </p>
    <p>
        <textarea placeholder="本文" cols="60" rows="10" bind:value={content}/>
    </p>
    <button on:click={submit}>投稿する</button>
    <button on:click={reset}>リセットする</button>
</form>

<style>

</style>