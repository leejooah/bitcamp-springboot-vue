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
                <span @click="transferPage(pager.preBlock+1)" v-if="pager.existPrev" style="width: 50px; height: 50px; border: 1px solid #000000; margin: 5px">이전</span>
                <span @click="transferPage(i)" v-for="i of pages" :key="i" style="width: 50px; height: 50px; border: 1px solid black;  margin: 5px" >{{i}}</span>
                <span @click="transferPage(pager.nextBlock+1)" v-if = "pager.existNext" style="width: 50px; height: 50px; border: 1px solid black;  margin: 5px">다음</span>

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
    import {proxy} from './mixins/proxy'
    export default {
        mixins : [proxy],
        name: "Movie",
        data () {
            return {

            }
        },
        methods : {
            transferPage(d){
                this.$store.dispatch('search/transferPage',{cate : 'movies',searchWord : 'null', pageNumber : d-1})
            }
        },
        computed : {
            ...mapState({
                list : (state)=> state.search.list,
                pages : (state) =>  state.search.pages,
                pager : (state) => state.search.pager

            })
        },
        created() {
        let json = proxy.methods.paging(`${this.$store.state.search.context}/movies/null/0`)
            this.$store.state.search.list = json.movies
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
        },
    }

</script>

<style scoped>

</style>