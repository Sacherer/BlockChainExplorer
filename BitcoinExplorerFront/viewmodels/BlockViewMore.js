var app = new Vue({
    el: '#app',
    data: {
        blocks: [],
        loading: true,
        nowDate:'' ,
        time:''
    },
    mounted() {
        this.getBlock();
        this.$watch('blocks', function (val) {
            this.$nextTick(function () {
                this.loading = false;
            });
        })
    },
    methods: {
        getBlock() {
            axios.get('/block/blockList/' + new Date().toLocaleDateString().replace(RegExp("/", "g"), "-") + '/' + 0 )
                .then(function (response) {
                    app.blocks = response.data
                    if (response.data.length > 0) {
                        app.time = response.data[0].time
                    }else{
                        app.time=new Date().getTime();
                    }
                })
        },
        currentHeight(index, row) {
            location.href = "BlockByHeight.html?height=" + row.height
        },
        currentHash(index, row) {
            location.href = "BlockByHash.html?blockhash=" + row.blockhash
        },
        currentPrev() {
            axios.get('/block/blockList/' + new Date(app.time).toLocaleDateString().replace(RegExp("/", "g"), "-") + '/' + (-1) )
                .then(function (response) {
                    app.blocks = response.data
                    if (response.data.length > 0) {
                        app.time = response.data[0].time
                    }else{
                        app.time = app.time-60*60*24*1000;
                    }
                })
        },
        currentNext() {
            axios.get('/block/blockList/' + new Date(app.time).toLocaleDateString().replace(RegExp("/", "g"), "-") + '/' + (1) )
                .then(function (response) {
                    app.blocks = response.data
                    if (response.data.length > 0) {
                        app.time = response.data[0].time
                    }else{
                        app.time = app.time+60*60*24*1000;
                    }

                })
        }
    }
})