import axios from 'axios'
import router from '@/router'
const state = {
    context : 'http://localhost:5000/',
    bugsmusic : [],
    count : 0
}
const actions = {
    async search({commit},payload){
        const url = state.context +`proxy/bugsmusic`
        const headers = {
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(url,payload,headers)
            .then(({data})=>{
                commit('search',data)
                router.push('/retriever')
            })
        .catch(()=>
        {
            alert('서버진입실패')
        })
      }
}
const mutations = {
   search(state, data){
       state.bugsmusic = []
       state.count = data.count
        data.list.forEach( (item)=>{
            state.bugsmusic.push({
                seq : item.seq, artists : item.artists, title : item.title, thumbnail : item.thumbnail})
        })
    }
}
const getters = {
    bugsmusic : state => state.bugsmusic,
    count : state => state.count
}
export default {
name : 'crawling',
    namespaced : true, //이름에 공간을 부여한다
    state,
    actions,
    mutations,
    getters
}
