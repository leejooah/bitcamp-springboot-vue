<template>
    <v-app>
    <div id = "wrapper">
        <div>
            <h1 id = "main">벅스 크롤링</h1>
            <input type="text" placeholder="검색어를 입력하세요" v-model ="searchWord" @keyup.enter="search"/>

                    <v-btn icon @click = "search">
                        <v-icon>mdi-magnify</v-icon>
                    </v-btn>



        </div>

    </div>
    </v-app>
</template>

<script>
    export default {
        name: "Home",
        data(){
            return{
           searchWord : '',
            }
        },
        created() {
            alert('홈에서 크리티드 실행됨')
        },
        methods : {
            search() {
                this.$store.dispatch('search/find', this.searchWord)
                }
            }


    }


</script>

<style scoped>


    #wrapper {
        text-align: center;
        padding: 5px;
        width: 960px;
        margin: 20px auto;
    }
    #main {
        margin-top: 200px;
        width: 100%;
    }


    input[type=text] {
        margin-top: 30px ;
        width: 500px;
        padding: 12px 20px;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
</style>