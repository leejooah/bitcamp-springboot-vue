import axios from "axios";

export const proxy={
    methods:{
        paging(url) {
            const movies = []
            const pages = []
            let temp = {}
            axios.get(url).
            then(({data})=>{
                data.list.forEach(elem=>movies.push(elem))
                let pager= data.pager
                let i =  pager.startPage+1
                for(; i<= pager.endPage+1;i++){
                    pages.push(i)
                }
                temp.rowCount = pager.rowCount
                temp.existPrev = pager.existPrev
                temp.existNext = pager.existNext
                temp.nextBlock = pager.nextBlock
            })
                .catch(()=>{
                    alert('통신 실패')
                })
            return {movies, pages, temp}
        }
    }


}