<script>
    export let data;
</script>
<h1>画像テスト</h1>

<div class="base">
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