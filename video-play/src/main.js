import Vue from 'vue'
import App from './App.vue'
import VueResource from "vue-resource";
import VideoPlayer from "vue-video-player";
Vue.use(VueResource);
Vue.use(VideoPlayer);
Vue.config.productionTip = false


new Vue({
  render: h => h(App),
}).$mount('#app')
