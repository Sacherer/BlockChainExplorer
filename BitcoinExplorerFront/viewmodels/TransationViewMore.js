var app = new Vue({
    el: '#app',
    data: {
        txs: [],
        loading: true,
        rate:''
    },
    mounted() {
        this.getMovementTxIndex();
        this.getRate();
        this.$watch('txs',function(val){  
            this.$nextTick(function() {  
               this.loading=false;
            });  
        }) 
    },
    methods: {
        getTx() {
            axios.get('/tx/moreTx', {

            })
                .then(function (response) {
                    app.txs=response.data
                })
        },
        getRate(){
            axios.get('/tx/getRate')
            .then(function (response) {
                app.rate=response.data;
            })
        },
        currentTxHash(index,row){
            location.href="TransationByHash.html?txhash="+row.txhash
        },
        getMovementTxIndex(){
            this.socket = new SockJS('http://localhost:8080/movement');
            this.stompclient = Stomp.over(this.socket);
            this.stompclient.connect({}, frame => {
                this.stompclient.subscribe('/topic/txMore', function (data) {
                    var txsJson=JSON.parse(data.body);
                    app.txs=txsJson;
                });
            });
        }
    }
})