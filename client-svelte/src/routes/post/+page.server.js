import {redirect} from '@sveltejs/kit';

export const actions = {
    create: async ({request, fetch}) => {
        const data = await request.formData();
        const article = {
            title: data.get('title'),
            author: data.get('author'),
            content: data.get('content')
        };
        await fetch('/api/articles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(article)
        });

        redirect(301, "/articles");
    },
    reset: () => {
        redirect(301, "/post");
    }
};
