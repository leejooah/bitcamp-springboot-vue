<template>
    <v-app>
        <v-container>
                <v-simple-table>
                    <template v-slot:default>
                        <thead>
                        <tr>
                            <th class="text-left">N0.</th>
                            <th class="text-left">이미지</th>
                            <th class="text-left">노래제목</th>
                            <th class="text-left">가수</th>


                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="item of bugsmusic" :key="item.seq">
                            <td>{{ item.seq}}</td>
                            <td><img src=" item.thumbnail" /></td>
                            <td>{{ item.title }}</td>
                            <td>{{ item.artists }}</td>


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
                bugsmusic : (state)=> state.crawling.bugsmusic,
                count : (state) =>  state.crawling.count
            })
        },
    }
</script>

<style scoped>

</style>