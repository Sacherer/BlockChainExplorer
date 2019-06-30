var app = new Vue({
    el: '#app',
    data: {
    },
	computed:{
		
	},
    mounted() {
        this.any();

        var url = new URL(location.href);
        var id = url.searchParams.get("any");
    },
    methods: {
        any(){
            axios.get('url', {
                 params: {
                   
                }
            })
            .then(function (response) {
                        
            })
            .catch(function (error) {
                     
            });
        }
    }
})