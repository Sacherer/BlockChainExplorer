
var app = new Vue({
    el: '#app',
    data: {
        blocks:[],
        txs:[],
        search:'',
        options: [{
            value: '1',
            label: 'Bitcoin'
          }, {
            value: '2',
            label: 'Ethereum'
          }],
          type:'1',
          loading:true,
          blockchainId:'1',
          rate:'',
          socket: '',
          stompclient: ''
    },
   
    mounted() {
        this.getRate();
        this.getBlock();
        // this.getTx();
        this.getMovementTxIndex();
        this.$watch('blocks',function(val){  
            this.$nextTick(function() {  
               this.loading=false;
            });  
        })  
        this.$watch('txs',function(val){  
            this.$nextTick(function() {  
               this.loading=false;
            });  
        }) 
        
       
    },
    methods: {
        getBlock() {
            axios.get('/block/blockIndex/',{

            })
                .then(function (response) {
                    app.blocks=response.data
                })
        },
        getTx() {
            axios.get('/tx/txIndex', {

            })
                .then(function (response) {
                    app.txs=response.data
                })
        },
        autoAddress(){
            this.search="2MxMX5MahsdLgY394bQPc5vfjaroVNfoYSc"
        },
        autoTransaction(){
            this.search="030086302619f83368fa0647c33ceced2843e7d5187891a2e52b2f85b8af8c54"
        },
        autoBlock(){
            this.search="00000000000007eb7915fdbf920a50286c6472a0aa1f5caa079967a997b9adf4"
        },
        autoHeight(){
            this.search="1566271"
        },
        moreBlock(){
            location.href="BlockViewMore.html"
        },
        moreTx(){
            location.href="TransationViewMore.html"
        },
        submit(){
            if(this.search.replace(/(^\s*)|(\s*$)/g, "")!=''){
                axios.get('/blockChain/search/'+this.blockchainId+'/'+this.search)
                .then(function (response) {
                    var result = response.data
                    if(result==''){
                        alert("We couldn’t find what you are looking for!")
                    }else{
                        location.href=result
                    }
                })
            }else{
                alert("please input something")
            }
        },
        currentHeight(index,row){
            location.href="BlockByHash.html?blockhash="+row.blockhash
        },
        currentTxHash(index,row){
            location.href="TransationByHash.html?txhash="+row.txhash
        },
        currentGetBlock(tab){
            if(tab.index==0){
                this.getBlock();
            }
            // if(tab.index==1){
            //     // this.getTx();
            //     this.getMovementTxIndex();
            // }
        },
        getRate(){
            axios.get('/tx/getRate')
            .then(function (response) {
                app.rate=response.data;
            })
        },
        getMovementTxIndex(){
            this.socket = new SockJS('http://localhost:8080/movement');
            this.stompclient = Stomp.over(this.socket);
            this.stompclient.connect({}, frame => {
                this.stompclient.subscribe('/topic/txIndex', function (data) {
                    var txsJson=JSON.parse(data.body);
                    app.txs=txsJson;
                });
            });
        }
    }
})
