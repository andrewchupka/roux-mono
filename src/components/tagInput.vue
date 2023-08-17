<template>
    <input @keyup.enter="addTag" @keyup.space="normalizeInput" v-model="tagInput">
    <Tag @deleteTag="this.tags = this.tags.filter(item => item !== $event)" v-for="tag in tags" :name="tag"></Tag>
</template>

<script>
import Tag from './Tag.vue'
export default {
  components: { Tag },
  data() {
    return {
      tagInput: "",
      tags: [ "gravy" ]
    }
  },
  methods: {
    addTag() {
      if (this.tags.includes(this.tagInput)) {
        console.log(`${this.tagInput} has already been added`)
      } else {
        this.tags.push(this.tagInput);
      }

      this.tagInput = "";
    },
    getTags() {
      return this.tags;
    },
    normalizeInput() {
      // strip off the space
      this.tagInput = this.tagInput.substring(0, this.tagInput.length - 1) + "-";
    }
  }
}
</script>

<style scoped>

</style>