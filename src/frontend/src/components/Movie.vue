<template>
    <v-app>
        <v-container>
            <h3>총 결과 : {{pager.rowCount}}</h3>
                <v-simple-table>
                    <template v-slot:default>
                            <thead>
                            <tr>
                                <th class="text-left">No.</th>
                                <th class="text-left">Rank</th>
                                <th class="text-left">타이틀</th>
                                <th class ="text-left">집계일</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="item of list" :key="item.movieSeq">
                                <td>{{item.movieSeq}}</td>
                                <td>{{ item.rank}}</td>
                                <td>{{item.title}}</td>
                                <td>{{item.rankDate}}</td>
                            </tr>
                            </tbody>
                        </template>
                </v-simple-table>
            <div class="text-center">
                <div style="margin: 0 auto; width: 500px; height: 100px;"></div>
                <span v-if="pager.existPrev" style="width: 50px; height: 50px; border: 1px solid #000000; margin: 5px">이전</span>
                <span style="width: 50px; height: 50px; border: 1px solid black;  margin: 5px"  v-for="i of pages" :key="i">{{i}}</span>
                <span v-if = "pager.existNext" style="width: 50px; height: 50px; border: 1px solid black;  margin: 5px">다음</span>
            </div>

<!--                        <v-pagination-->
<!--                                v-model="page"-->
<!--                                class="my-4"-->
<!--                                :length="15"-->
<!--                        ></v-pagination>-->

        </v-container>
    </v-app>
</template>

<script>
    import {mapState} from 'vuex'
    import axios from "axios";
    export default {
        name: "Movie",
        data () {
                return {
                    pageNumber: 0,
                   pages : [],
                    list :[],
                    pager : {},
                    totalCount : ''
            }
        },
        created() {
            axios.get(`${this.$store.state.search.context}/movies/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                .then(res=>{
                   res.data.list.forEach(elem=>this.list.push(elem))
                    this.pager= res.data.pager
                    let i =  this.pager.startPage+1
                    let arr = []
                    console.log(`페이지 끝 : ${this.pager.endPage}`)
                    for(; i<= this.pager.endPage+1;i++){
                        arr.push(i)
                    }
                    this.pages=arr
                })
                .catch(()=>{
                    alert('영화 통신 실패')
                })
        },
        computed : {
            ...mapState({
                searchResult : (state)=> state.search.searchResult,
                count : (state) =>  state.search.count,
            })
        },
    }
</script>

<style scoped>

</style>