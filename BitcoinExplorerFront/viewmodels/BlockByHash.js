var app = new Vue({
    el: '#app',
    data: {
        blocks: '',
        loading: true,
        list: [

        ]
    },
    mounted() {
        var url = new URL(location.href);
        var blockhash = url.searchParams.get("blockhash");
        this.getblock(blockhash);
        this.$watch('blocks', function (val) {
            this.$nextTick(function () {
                this.loading = false;
            });
        })
    },
    methods: {
        getblock(blockhash) {
            axios.get('/block/blockDetail/' + blockhash)
                .then(function (response) {
                    var block = response.data
                    app.blocks = block;
                    app.list = block.txs;
                })
        },
        currentHeight(height) {
            location.href = "BlockByHeight.html?height=" + height
        },
        currentHash(hash) {
            location.href = "BlockByHash.html?blockhash=" + hash
        },
        currentTxHash(txhash) {
            location.href = "TransationByHash.html?txhash=" + txhash
        },
        currentAddress(address) {
            location.href = "AddressDetail.html?address=" + address
        }
    }
})