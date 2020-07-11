<template>
  <div id="app">
    <VideoPlay msg="Welcome to My VideoWebsite"/>
  </div>
</template>

<script>
import VideoPlay from './components/VideoPlay.vue'

export default {
  name: 'App',
  components: {
    VideoPlay
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
