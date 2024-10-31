<template>
  <div class="directionGroup">
    <div v-for="(item, index) in steps" :key="index">
      <label :for="index">{{ index + 1 }}</label>
      <textarea 
        :id="index" 
        :ref="index"
        @keyup="addDirection(index, item)"
        v-model="item['text']" 
        cols="100" 
        rows="2">
      </textarea>
    </div>
  </div>
</template>

<script>
export default {
  name: "DirectionInput",
  props: {
    steps: Array
  },
  
  methods: {
    addDirection(index, item) {
      item.text = item.text.replace("\n", "");

      if (this.steps[index + 1] === undefined) {
        this.steps.push({order: index + 2})
      }
    }
  }
}
</script>

<style scoped>
  label {
    padding-right: 15px;
  }

  .directionGroup {
    display: flex; 
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-around;
    background-color: gray;
  }
</style>