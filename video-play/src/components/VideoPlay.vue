<template>
  <div id="VideoPlay">
    <h1 class="text-center">Video Player</h1>
    <div class="table-container">
      <table :data="files" class="table table-striped table-bordered table-hover table-condensed">
        <thead>
          <tr>
            <th>Index</th>
            <th>Name</th>
            <th>Choices</th>
          </tr>
        </thead>
        <tbody>
          <tr v-on:click="getIndex(index)" v-for="(file, index) in files" v-bind:key="file">
            <td>{{index}}</td>
            <td>
              <div class="filename">{{file}}</div>
            </td>
            <td>
              <button
                type="button"
                class="btn btn-primary"
                style="margin:5px"
                v-on:click="changeto720(file)"
              >360p</button>
              <button
                type="button"
                class="btn btn-success"
                style="margin:5px"
                v-on:click="changeto720(file)"
              >720p</button>
              <button
                type="button"
                class="btn btn-warning"
                style="margin:5px"
                v-on:click="changeto1080(file)"
              >1080p</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div id="player" class="player-container">
      <!--
      <video-player
        class="video-player vjs-custom-skin"
        ref="videoPlayer"
        :playsinline="true"
        :options="playerOptions"
      ></video-player>-->
      <video ref="videoPlay" :src="videoURL" controls></video>
    </div>
  </div>
</template>

<script>
export default {
  name: "VideoPlay",
  components: {},
  computed: {
    player() {
      return this.$refs.videoPlayer.player;
    }
  },
  data() {
    return {
      files: [],
        
      playerOptions: {
        playbackRates: [0.5, 1.0, 1.5],
        videoURL:"",
        fluid: true,
        sources: [
          {
            type: "video/mp4", 
            src:""
          }
        ],
        width: document.documentElement.clientWidth, 
        controlBar: {
          timeDivider: true,
          durationDisplay: true,
          remainingTimeDisplay: false
        }
      }
    };
  },
  created(){
    this.$http.get("http://localhost:8081/files").then(function(res) {
        this.files = res.body;
        console.log(this.files);
      });
  },
  mounted() {
     this.$http.get("http://localhost:8081/files").then(function(res) {
        this.files = res.body;
        console.log(this.files);
      });
  },
  methods: {
    getIndex(file) {
      console.log(file.id);
    },
    getFiles: function() {
      this.$http.get("http://localhost:8081/files").then(function(res) {
        this.files = res.body;
        console.log(this.files);
      });
    },
    changeto360(name) {
      this.videoURL = "http://localhost:8081/play/360/" + name;
      console.log(this.videoURL);
      this.$nextTick(() => {
        this.$refs.videoPlay.load();
      });
    },
    changeto720(name) {
      this.videoURL = "http://localhost:8081/play/720/" + name;
      console.log(this.videoURL);
      this.$nextTick(() => {
        this.$refs.videoPlay.load();
      });
    },
    changeto1080(name) {
      this.videoURL = "http://localhost:8081/play/1080/" + name;
      console.log(this.videoURL);
      this.$nextTick(() => {
        this.$refs.videoPlay.load();
      });
    }
  }
};
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
.player-container {
  margin: auto;
  width: 100%;
}
.video-js .vjs-icon-placeholder {
  width: 100%;
  height: 100%;
  display: block;
}
</style>
