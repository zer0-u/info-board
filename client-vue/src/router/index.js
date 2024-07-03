import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ArticleView from "@/views/ArticleView.vue";
import PostView from "@/views/PostView.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView
        },
        {
            path: '/articles',
            name: 'articles',
            component: ArticleView
        },
        {
            path: '/post',
            name: 'post',
            component: PostView
        }
    ]
})

export default router
