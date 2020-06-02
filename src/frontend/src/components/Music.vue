<template>
    <v-app>
        <v-container>
                <v-simple-table>
                    <template v-slot:default>
                            <template v-if="type==='벅스뮤직'">
                        <thead>
                        <tr>
                            <th class="text-left">N0.</th>
                            <th class="text-left">이미지</th>
                            <th class="text-left">노래제목</th>
                            <th class="text-left">가수</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="item of searchResult" :key="item.seq">
                            <td>{{ item.seq}}</td>
                            <td><img src=" item.thumbnail" /></td>
                            <td>{{ item.title }}</td>
                            <td>{{ item.artists }}</td>
                        </tr>
                        </tbody>
                            </template>
                        <template v-else-if="type==='네이버영화'">
                            <thead>
                            <tr>
                                <th class="text-left">N0.</th>
                                <th class="text-left">타이틀</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="item of searchResult" :key="item.seq">
                                <td>{{ item.rank}}</td>
                                <td>{{item.title}}</td>
                            </tr>
                            </tbody>
                        </template>
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
        name: "Music",
        data () {
                return { page: 1,
            }
        },
        computed : {
            ...mapState({
                searchResult : (state)=> state.crawling.searchResult,
                count : (state) =>  state.crawling.count,
                type : (state) => state.crawling.type
            })
        },
    }
</script>

<style scoped>

</style>