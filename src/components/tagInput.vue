<template @deleteField="this.tags = this.tags.filter(item => item !== $event)">
    <input @keyup.enter="addTag" v-model="tagInput">
    <RemoveField v-for="tag in tags" :name="tag"></RemoveField>
</template>

<script>
import RemoveField from './RemoveField.vue'
export default {
  components: { RemoveField },
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
  }
}
</script>

<style scoped>

</style>