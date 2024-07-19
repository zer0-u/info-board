import {fail, redirect} from '@sveltejs/kit';

function hasError(input) {
    const required = '必須入力です';
    if (input.title.value === "") {
        input.title.errors.push(required);
    }
    if (input.author.value === "") {
        input.author.errors.push(required);
    }
    if (input.content.value === "") {
        input.content.errors.push(required);
    }
    return input.title.errors.length || input.author.errors.length || input.content.errors.length;
}

export const actions = {
    create: async ({request, fetch}) => {
        const data = await request.formData();
        const input = {
            title: {value: data.get('title'), errors: []},
            author: {value: data.get('author'), errors: []},
            content: {value: data.get('content'), errors: []},
        }
        if (hasError(input)) {
            return fail(400, input);
        }
        const images = JSON.parse(data.get('base64Images'));
        await fetch('/api/articles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title: input.title.value,
                author: input.author.value,
                content: input.content.value,
                images: images,
            })
        });
        redirect(301, "/articles");
    },
    reset: () => {
        redirect(301, "/post");
    }
};
