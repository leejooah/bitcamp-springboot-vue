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
        methods : {
            search() {
                switch (this.searchWord) {
                    case '벅스뮤직': this.$store.dispatch('crawling/search', this.searchWord); break;
                    case '축구':  this.$store.dispatch('soccer/search', this.searchWord); break;
                    case '네이버영화':
                        this.$store.dispatch('crawling/search', this.searchWord); break;

                }
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