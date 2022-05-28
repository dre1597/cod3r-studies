<template>
  <v-container fluid>
    <v-form>
      <v-file-input
        label="Choose the .srt file"
        prepend-icon="mdi-message-text"
        append-icon="mdi-send"
        outlined
        multiple
        chips
        v-model="files"
        @click:append="processSubtitles"
      />
    </v-form>
    <div class="btn-container" v-if="show">
      <h2 class="message">{{ processMessage }}</h2>
      <v-btn
        @click="topFive"
        class="btn"
        color="primary"
        elevation="5"
        rounded
        large
        >Top 5</v-btn
      >
      <v-btn
        @click="topTen"
        class="btn"
        color="primary"
        elevation="5"
        rounded
        large
        >Top 10</v-btn
      >
      <v-btn
        @click="printAll"
        class="btn"
        color="primary"
        elevation="5"
        rounded
        large
        >All top words</v-btn
      >
    </div>

    <div class="pills">
      <Pill
        v-for="word in wordsRender"
        :key="word.name"
        :name="word.name"
        :amount="word.amount"
      />
    </div>
  </v-container>
</template>

<script>
import { ipcRenderer } from 'electron';
import Pill from './Pill';
export default {
  components: { Pill },
  data: function () {
    return {
      files: [],
      groupedWords: [],
      wordsRender: [],
      processMessage: '',
      show: false,
    };
  },
  methods: {
    processSubtitles() {
      const paths = this.files.map((file) => file.path);
      ipcRenderer.send('process-subtitles', paths);
      ipcRenderer.on('process-subtitles', (event, resp) => {
        this.groupedWords = resp;
      });
      this.show = true;
      this.processMessage =
        'The process phase is over! Choose a option by clicking on the buttons below!';
    },
    topFive() {
      this.processMessage = '';
      this.wordsRender = this.groupedWords.slice(0, 5);
    },
    topTen() {
      this.processMessage = '';
      this.wordsRender = this.groupedWords.slice(0, 10);
    },
    printAll() {
      this.processMessage = '';
      this.wordsRender = this.groupedWords;
    },
  },
};
</script>

<style lang="sass" scoped>
.btn-container
    text-align: center
.message
    color: green
.btn
    margin: 10px

.pills
    display: flex
    flex-wrap: wrap
    justify-content: space-evenly
</style>
