<template>
  <img alt="Vue logo" src="./assets/logo.png" />
  <HelloWorld msg="Hello Vue 3.0 + Vite" />
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data(){
    return{
      name: '' ,
      author: '' ,
      description: ''

    }
  },
  methods:{
    async listing(){
      let details={
      name: this.name,
      author: this.author,
      description:this.description
      }
      let article = await fetch('/rest/listing', {
        method:'POST' ,
        headers:{'content-type': 'application/json'},
        body: JSON.stringify(details)
      })
      console.log(await article.json());
    }
  },
  async mounted(){
    let article = await fetch('/rest/listed')
    if(article.ok){
      article = await article.json()
      console.log(article);
    }

  }
}
</script>
