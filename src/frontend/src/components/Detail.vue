<template>
    <div>
    <span style="float : right"><input id="searchWord" type="text" style="border: 1px solid black" @keyup.enter="search">
                <button @click="search">검색</button></span><br><br>
        <v-simple-table class="border_black">
            <template v-slot:default>

                <thead>
                <tr>
                    <th class="text-left">Image</th>
                    <th class="text-left">No.</th>
                    <th class="text-left">Rank</th>
                    <th class="text-left">타이틀</th>
                    <th class ="text-left">집계일</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><img src="https://lh3.googleusercontent.com/proxy/KWt98K4-XUTcIRmC2sdEnccM8ZHLW49PW_gR0NHT8ipvD_ncV2yKtnqYs6dfq8JQA-6TO9oN7jzQymyo8KKxE3zJjeNxDCHbOI6TEEti6Bpmjrq2_IVwFT5h2rLNYJIBLo13CU6p_w"/></td>
                    <td>{{item.movieSeq}}</td>
                    <td>{{item.rank}}</td>
                    <td>{{item.title}}</td>
                    <td>{{item.rankDate}}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
    </div>
</template>

<script>
import {mapState} from 'vuex'
   import '@/assets/css/main.css'
   import axios from "axios";
    export default {
        computed : {
            ...mapState({
                item : (state) => state.search.item
            })
        },
        created() {
            axios.
            get(this.$store.state.search.context+`/movies/`+sessionStorage.getItem('movieSeq'))
                .then(({data})=>{
                    this.$store.state.search.item = data
                })

        }


    }



</script>

<style scoped>

</style>