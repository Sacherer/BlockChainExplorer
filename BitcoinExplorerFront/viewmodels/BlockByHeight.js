var app = new Vue({
    el: '#app',
    data: {
        blocks: '',
        loading:true
    },
    mounted() {
        var url = new URL(location.href);
        var height = url.searchParams.get("height");
        this.getblock(height);
        this.$watch('blocks', function (val) {
            this.$nextTick(function () {
                this.loading = false;
            });
        })
    },
    methods: {
        getblock(height) {
            axios.get('/block/getBlockByHeight/' + height
            )
                .then(function (response) {
                    app.blocks = response.data
                })
        },
        currentHeight(height) {
            location.href = "BlockByHeight.html?height=" + height
        },
        currentHash(hash) {
            location.href = "BlockByHash.html?blockhash=" + hash
        }
    }
})