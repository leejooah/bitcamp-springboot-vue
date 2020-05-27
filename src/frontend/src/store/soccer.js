import axios from 'axios'
const state = {
    context : 'http://localhost:5000/'
}
const actions = {
    async search({commit},payload){
        const url = state.context+`proxy/soccer`
        const headers = {
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(url,payload,headers)
            .then(()=>{
                commit('search')
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