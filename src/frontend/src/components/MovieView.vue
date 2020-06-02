<template>
    <v-app>
        <v-container>
            <h3>총 결과 : {{count}}</h3>
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
                            <tr v-for="item of searchResult" :key="item.movieSeq">
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
                <span v-if="existPrev" style="width: 50px; height: 50px; border: 1px solid #000000; margin: 5px">이전</span>
                <span style="width: 50px; height: 50px; border: 1px solid black;  margin: 5px"  v-for="i of arr" :key="i">{{i}}</span>
                <span v-if = "existNext" style="width: 50px; height: 50px; border: 1px solid black;  margin: 5px">다음</span>
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
    export default {
        name: "Retriever",
        data () {
                return {
                     existPrev : false, existNext : true,
                    arr : [6,7,8,9,10]
            }
        },
        created() {
            alert('무비에서 크리티드 실행됨')
        },
        computed : {
            ...mapState({
                searchResult : (state)=> state.crawling.searchResult,
                count : (state) =>  state.crawling.count,
            })
        },
    }
</script>

<style scoped>

</style>