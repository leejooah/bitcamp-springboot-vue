<template>
    <v-app>
        <v-container>
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
                        <v-pagination
                                v-model="page"
                                class="my-4"
                                :length="15"
                        ></v-pagination>

        </v-container>
    </v-app>
</template>

<script>
    import {mapState} from 'vuex'
    export default {
        name: "Retriever",
        data () {
                return { page: 1,
            }
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