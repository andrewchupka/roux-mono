<template>
  <div class="cookTime">
    <TimeInput :name="'Prep'" :time="prep"></TimeInput>
    <div class="break"></div>
    <TimeInput :name="'Cook'" :time="cook"></TimeInput> 
    <div class="break"></div>
    <TimeInput :name="'Total'" :time="total"></TimeInput>
  </div>
</template>

<script>
import TimeInput from './TimeInput.vue';
export default {
  name: "CookTimeInput",
  components: {TimeInput},
  data() {
    return {
      prep: {hours: 0, minutes: 0},
      cook: {hours: 0, minutes: 0},
      total: {hours: 0, minutes: 0},
    }
  },
  watch: {
    prep: {
      handler(newValue, oldValue) {
        this.updateTotal()
      },
      deep: true
    },
    cook: {
      handler(newValue, oldValue) {
        this.updateTotal()
      },
      deep: true
    }
  },
  methods: {
    updateTotal() {
      let totalMinutes = this.prep.minutes + this.cook.minutes
      this.total.minutes = totalMinutes % 60
      this.total.hours = this.prep.hours + this.cook.hours + Math.floor(totalMinutes / 60)
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