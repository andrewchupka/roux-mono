<template>
  <div class="removeField">
    <div :style="cssProps">
      <span class="name">{{ name }}</span>
      <button @click="$emit('deleteTag', this.name)">
        <img
          src="https://www.svgrepo.com/show/12848/x-symbol.svg"
          width="10"
          height="10"
        />
      </button>
    </div>
  </div>
</template>

<script>
import { hashString } from "../util/stringUtils.js";

export default {
  props: {
    name: String,
  },
  computed: {
    cssProps() {
      // Get a unique, numeric hash of the name
      var code = hashString(this.name);

      // Get code for each of the colors 
      var red = code % 255;
      var green = (code * 7) % 255;
      var blue = (code * 5) % 255;

      // Construct the hex string representing the background color of the tag
      var color = "#";
      color += red.toString(16).padStart(2, "0");
      color += green.toString(16).padStart(2, "0");
      color += blue.toString(16).padStart(2, "0");

      // Get the brightnes of the color to determine contrast
      const brightness = (red * 299 + green * 587 + blue * 114) / 1000;

      console.log(color);
      return {
        "background-color": `${color}`,
        "color": brightness > 128 ? "#000000" : "#FFFFFF", // Choose white or black as the contrasting color
      };
    },
  },
  methods: {},
};
</script>

<style>
.removeField span {
  padding: 5px;
  padding-right: 30px;
}

.removeField button {
  background-color: transparent;
  transition-duration: 0.4s;
  border-radius: 50%;
}

.removeField button:hover {
  background-color: white;
}

.removeField div {
  display: inline-block;
  padding: 8px;
  border-radius: 25px;
  margin-top: 8px;
}
</style>
