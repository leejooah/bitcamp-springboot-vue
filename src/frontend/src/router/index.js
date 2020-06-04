import vue from 'vue'
import router from 'vue-router'
import Detail from "../components/Detail";
import Home from "../components/Home";
import Music from "../components/Music";
import Movie from "../components/Movie";
vue.use(router)
export default new router({
    mode : 'history',
    routes : [
        {path : '/', component : Home},
        {path : '/music', component: Music},
        {path:  '/movie', component: Movie },
        {path: '/detail', component: Detail}
    ]
})