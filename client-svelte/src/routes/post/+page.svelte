<script>

</script>

<h1>お知らせを投稿する</h1>
<form method="POST">
    <p>
        <label>
            タイトル
            <input type="text" size="40" name="title" autocomplete="off"/>
        </label>
    </p>
    <p>
        <label>
            投稿者名
            <input type="text" size="40" name="author" autocomplete="off"/>
        </label>
    </p>
    <p>
        <textarea placeholder="本文" cols="60" rows="10" name="content" autocomplete="off"/>
    </p>
    <button formaction="?/create">投稿する</button>
    <button formaction="?/reset">リセットする</button>
</form>

<style>

</style>