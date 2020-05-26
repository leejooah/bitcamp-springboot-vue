import vue from 'vue'
import router from 'vue-router'

import Home from "../components/Home";
import Retriever from "../components/Retriever";
vue.use(router)
export default new router({
    mode : 'history',
    routes : [
        {path : '/', component : Home},
        {path : '/retriever', component: Retriever}
    ]
})