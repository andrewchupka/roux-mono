<template>
  <div class="cookTime">
    <TimeInput :name="'Prep'" :time="time.prep"></TimeInput>
    <div class="break"></div>
    <TimeInput :name="'Cook'" :time="time.cook"></TimeInput> 
    <div class="break"></div>
    <TimeInput :name="'Total'" :time="time.total"></TimeInput>
  </div>
</template>

<script>
import TimeInput from './TimeInput.vue';
export default {
  name: "CookTimeInput",
  components: {TimeInput},
  props: {
    time: Object
  },
  watch: {
    time: {
      handler(newValue, oldValue) {
        this.updateTotal()
      },
      deep: true
    },
  },
  methods: {
    updateTotal() {
      let totalMinutes = this.time.prep.minutes + this.time.cook.minutes
      this.time.total.minutes = totalMinutes % 60
      this.time.total.hours = parseInt(this.time.prep.hours + this.time.cook.hours + Math.floor(totalMinutes / 60))
    },
    getTime() {
      return {
        prep: this.prep,
        cook: this.cook,
        total: this.total
      }
    }
  }

}
</script>

<style scoped>
.cookTime {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

.break {
  flex-basis: 100%;
  height: 0;
}
</style>