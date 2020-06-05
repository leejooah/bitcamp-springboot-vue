import router from '@/router'
import axios from 'axios'
const state = {
    context : 'http://localhost:5000',
   list : [],
    pages : [],
    pager :  {},
    pageNumber: 0,
    searchWord: 'null',
    item : {}
}
const actions = {
    async find({commit},searchWord) {
        commit('searchWord',searchWord)
        switch (searchWord) {
            case '영화' :
                router.push("/movie");
                break;
            case '음악' :
                router.push("/music");
                break;
            case '축구' :
                router.push("/soccer");
                break;
        }

    },
     async transferPage({commit},payload){
        axios.get(state.context+`/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
            .then(({data})=>{
                    commit('transfer',data)
            }

            )

     },


}
const mutations = {

    searchWord(state,data){
        state.searchWord = data
    },
    transfer(state, data){
        state.pager = data.pager
        state.list = data.list
        state.pages=[]
        let i = data.pager.startPage+1
        for(; i<=data.pager.endPage+1;i++){
            state.pages.push(i)
        }
    },

}
export default {
    name : 'search',
    namespaced : true,
    state,
    actions,
    mutations
}