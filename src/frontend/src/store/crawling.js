import axios from 'axios'
import router from '@/router'
const state = {
    context : 'http://localhost:5000/',
    bugsmusic : [],
    count : 0,
    navermovie : [],
}
const actions = {
    async search({commit},payload){
        const url = state.context +`proxy/crawling`
        const headers = {
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(url,payload,headers)
            .then(({data})=>{
                    commit('musicSearch',data)
                    router.push('/retriever')
            })
        .catch(()=>
        {
            alert('서버진입실패')
        })
      },
    async moviesearch({commit},payload){
        const url = state.context +`proxy/navermovie/`
        axios.get(url+payload)
            .then(({data})=>{
                commit('movieSearch',data)
                router.push('/retrieverCopy')
            })
            .catch(()=>
            {
                alert('서버진입실패')
            })
    }
}
const mutations = {
    musicSearch(state, data){
       state.bugsmusic = []
       state.count = data.count
        data.list.forEach( (item)=>{
            state.bugsmusic.push({
                seq : item.seq, artists : item.artists, title : item.title, thumbnail : item.thumbnail})
        })
    },
    movieSearch(state,data){
        state.navermovie = []
        state.count = data. count
        data.list.forEach((item)=>{
            state.navermovie.push({
                seq : item.movieNo, title : item.title
            })
        })
}
}
const getters = {
    bugsmusic : state => state.bugsmusic,
    count : state => state.count,
    navermovie : state => state.navermovie
}
export default {
name : 'crawling',
    namespaced : true, //이름에 공간을 부여한다
    state,
    actions,
    mutations,
    getters
}
