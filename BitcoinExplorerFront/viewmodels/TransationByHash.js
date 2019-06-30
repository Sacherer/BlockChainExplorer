var app = new Vue({
    el: '#app',
    data: {
        transactions:'',
        loading:true,
        list: [

        ]
    },
    mounted() {
        var url = new URL(location.href);
        var txhash = url.searchParams.get("txhash");
        this.getTransactions(txhash);
        this.$watch('transactions', function (val) {
            this.$nextTick(function () {
                this.loading = false;
            });
        })
    },
    methods: {
        getTransactions(txhash){
            axios.get('/tx/txDeatil/' + txhash)
            .then(function (response) {
                var transaction = response.data
                app.transactions = transaction;
                app.list = transaction.txs;
            })
        },
        currentHeight(height) {
            location.href = "BlockByHeight.html?height=" + height
        },
        currentTxHash(txhash){
            location.href="TransationByHash.html?txhash="+txhash
        },
        currentAddress(address) {
            location.href = "AddressDetail.html?address=" + address
        }
    }
        
})