import axios from 'axios'
import router from '@/router'
const state = {
    context : 'http://localhost:5000/',
   searchResult : [],
    count : 0,


}
const actions = {
    // async search({commit},payload){
    //     const url = state.context +`proxy/crawling`
    //     const headers = {
    //         authorization: 'JWT fefege..',
    //         Accept : 'application/json',
    //         'Content-Type': 'application/json'
    //     }
    //     axios.post(url,payload,headers)
    //         .then(({data})=>{
    //                 commit('musicSearch',data)
    //                 router.push('/retriever')
    //         })
    //     .catch(()=>
    //     {
    //         alert('서버진입실패')
    //     })
    //   },
    async search({commit},searchWord){
        switch (searchWord) {
            case '벅스뮤직' :
                 axios.post(state.context +`proxy/crawling`,searchWord, {
                     authorization: 'JWT fefege..',
                     Accept : 'application/json',
                     'Content-Type': 'application/json'})
                    .then((res)=>{
                            commit('search',res.data)
                            router.push('/retriever')
                    })
                .catch(()=>
                {
                    alert('서버진입실패')
                });
                break;

            case '네이버영화' :
                axios.get(state.context +`movie/list/0/${searchWord}`)
                    .then(({data})=>{
                        commit('movie',data)
                        router.push('/movieView')
                    })
                    .catch(()=>
                    {
                        alert('서버진입실패')
                    });
                break;
        }



    }
}
const mutations = {
    search(state, data){
       state.searchResult = []
       state.count = data.count
        alert('뮤테이션 진입')
        alert('넘어온 데이터 타입 ='+data.type)

            data.list.forEach( (item)=> {
                state.searchResult.push({
                    seq: item.seq, artists: item.artists, title: item.title, thumbnail: item.thumbnail
                })
            })
            router.push('/retriever')


    },

    movie(state,data){
    state.searchResult=[]
    state.count=data.pager.rowCount
    data.list.forEach( (item)=>{
        state.searchResult.push({
            movieSeq: item.movieSeq, rank : item.rank, title : item.title,  rankDate : item.rankDate})
    })

}


}
const getters = {
    searchResult : state => state.searchResult,
    count : state => state.count,

}
export default {
name : 'crawling',
    namespaced : true, //이름에 공간을 부여한다
    state,
    actions,
    mutations,
    getters
}
