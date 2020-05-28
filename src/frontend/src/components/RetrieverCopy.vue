<template>
    <v-app>
        <v-container>
                <v-simple-table>
                    <template v-slot:default>
                        <thead>
                        <tr>
                            <th class="text-left">N0.</th>
                            <th class="text-left">타이틀</th>



                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="item of navermovie" :key="item.seq">
                            <td>{{ item.seq}}</td>
                            <td>{{item.title}}</td>



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
        name: "RetrieverCopy",
        data () {
                return { page: 1,
            }
        },
        computed : {
            ...mapState({
                navermovie : (state)=> state.crawling.navermovie,
                count : (state) =>  state.crawling.count
            })
        },
    }
</script>

<style scoped>

</style>