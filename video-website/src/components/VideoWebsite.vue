<template>
  <div class="VideoWebsite">
    <table class="table table-striped table-bordered table-hover table-condensed">
      <thead>
        <tr>
          <th>Index</th>
          <th>Name</th>
          <th>Status</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        
        <tr v-on:click="getIndex(index)" v-for="(file, index) in files" :key="file.id">
          <td>{{index}}</td>
          <td>
            <div class="filename">{{file.name}}</div>
          </td>
           <td v-if="file.error">error</td>
          <td v-else-if="file.success">success</td>
          <td v-else-if="file.active">active</td>
          <td v-else></td>
           <td>
            <button
              type="button"
              class="btn btn-warning"
              href="#"
              v-if="file.error && file.error !== 'compressing' && $refs.upload.features.html5"
              @click.prevent="$refs.upload.update(file, {active: true, error: '', progress: '0.00'})"
            >Retry</button>
            <button
              type="button"
              class="btn btn-danger"
              href="#"
              @click.prevent="$refs.upload.remove(file)"
            >Delete</button>
          </td>
         </tr>
      </tbody>
    </table>
    <div class="example-btn text-center">
      <file-upload
        class="btn btn-lg btn-primary"
        style="margin:50px"
        post-action="http://localhost:8081/upload"
        :multiple="true"
        :drop="true"
        :drop-directory="true"
        v-model="files"
        ref="upload"
      >
        Select files
      </file-upload>
       <button
        type="button"
        class="btn btn-lg btn-success"
        style="margin:50px"
        @click.prevent="$refs.upload.active = true"
      >
        Start Upload
      </button>
      <button
        type="button"
        class="btn btn-lg btn-danger"
        style="margin:50px"
        @click.prevent="$refs.upload.active = false"
      >
        Stop Upload
      </button>
    </div>
  </div>
</template>

<script>
import FileUpload from "vue-upload-component"
export default {
  components: {
    FileUpload
  },
  data() {
    return {
      files: []
    };
  },
  methods: {
    getIndex(index) {
      console.log(index);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
