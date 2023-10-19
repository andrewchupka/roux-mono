<template>

  <label for="timeInput">{{ name }}</label>
  <div id="timeInput">
    <div class="time">
      <input 
        id="hours" 
        type="number" 
        v-model="time.hours"
      >
      <label for="hours"> hours</label>
    </div>

    <div class="time">
      <input 
        id="minutes"
        type="number" 
        v-model="time.minutes"
      >
      <label for="minutes"> minutes</label>
    </div>
  </div>
</template>

<script>
export default {
  name: "TimeInput",
  props: {
    name: String,
    time: Object
  }
}
</script>

<style scoped>
div {
  flex-direction: row;
  display: flex;
}
.time {
  margin: 3px;
}

.time > label {
  padding-left: 3px;
}

input {
  width: 10em;
}
</style>