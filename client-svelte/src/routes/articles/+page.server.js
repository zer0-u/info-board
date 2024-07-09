export async function load({fetch}) {
    const response = await fetch('/api/articles');
    if (response.status !== 200) {
        return {articles: []};
    }
    const articles = await response.json();
    return {
        articles
    };
}