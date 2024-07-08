<script>
    let title = '';
    let author = '';
    let content = '';
    let completed = false;

    function reset() {
        title = '';
        author = '';
        content = '';
    }

    function changeStatus() {
        completed = false;
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
        completed = true;
    }
</script>

<h1>お知らせを投稿する</h1>
<form>
    <p>
        <label>
            タイトル
            <input type="text" size="40" bind:value={title} on:input={changeStatus}/>
        </label>
    </p>
    <p>
        <label>
            投稿者名
            <input type="text" size="40" bind:value={author} on:input={changeStatus}/>
        </label>
    </p>
    <p>
        <textarea placeholder="本文" cols="60" rows="10" bind:value={content} on:input={changeStatus}/>
    </p>
    <button on:click={submit}>投稿する</button>
    <button on:click={reset}>リセットする</button>
</form>
{#if completed}
    <p>投稿しました</p>
{/if}

<style>

</style>