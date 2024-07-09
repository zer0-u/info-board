<script>
    let title = '';
    let author = '';
    let content = '';
    let completed = false;
    let hasError = false;

    function reset() {
        title = '';
        author = '';
        content = '';
        hasError = false;
    }

    function setUncompleted() {
        completed = false;
        hasError = false;
    }

    function setCompleted() {
        completed = true;
        hasError = false;
    }

    async function submit() {
        setUncompleted();
        const article = {
            title, author, content
        }
        if (!isValid(article)) {
            hasError = true;
            return;
        }
        await window.fetch('/api/articles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(article)
        });
        reset();
        setCompleted();
    }

    function isValid(article) {
        return article.title !== '' && article.author !== '' && article.content !== '';
    }
</script>

<h1>お知らせを投稿する</h1>
<form method="POST">
    <p>
        <label>
            タイトル
            <input type="text" size="40" name="title" autocomplete="off"/>
            {#if hasError && title === ""}<p class="error">必須入力です</p>{/if}
        </label>
    </p>
    <p>
        <label>
            投稿者名
            <input type="text" size="40" name="author" autocomplete="off"/>
            {#if hasError && author === ""}<p class="error">必須入力です</p>{/if}
        </label>
    </p>
    <p>
        <textarea placeholder="本文" cols="60" rows="10" name="content" autocomplete="off"/>
        {#if hasError && content === ""}<p class="error">必須入力です</p>{/if}
    </p>
    <button formaction="?/create">投稿する</button>
    <button formaction="?/reset">リセットする</button>
</form>

<style>
    .error {
        color: darkred;
        font-size: 0.8em;
    }
</style>