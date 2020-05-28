import axios from 'axios'
import router from '@/router'
const state = {
    context : 'http://localhost:5000/',
    soccer : []
}
const actions = {
    async search({commit},payload){
        const url = state.context+"proxy/soccer/"

        axios.get(url+payload)
            .then(({data})=>{
                commit('search',data)
                router.push("/home")
            })
            .catch(()=>{
                alert('서버연결실패')
            })
    }
}
const mutations = {
    search(){
        alert('뮤테이션 진입')
    }
}
const getters ={}
export default {
    name : 'soccer',
    namespaced : true,
    state,
    actions,
    mutations,
    getters
}