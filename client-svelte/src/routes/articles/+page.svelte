<script>
    import dayjs from "dayjs";

    export let data;
</script>

<h1>お知らせ一覧</h1>

<div>
    {#each data.articles as article}
        <div class="article">
            <h2>{article.title}</h2>
            <span class="author">
                <p>{article.author}</p>
                <p>{dayjs(article.createdAt).format("YYYY/MM/DD HH:mm")}</p>
            </span>
            <p>{article.content}</p>
            <div>
                {#each article.images as image}
                    <img src={`${image.header},${image.base64}`} alt={image.name}/>
                {/each}
            </div>
        </div>
    {/each}
</div>

<style>
    .author {
        color: darkgray;
    }

    .article {
        border: 1px solid black;
        padding: 1rem;
        margin: 1rem;
    }

    img {
        max-width: 100%;
    }
</style>