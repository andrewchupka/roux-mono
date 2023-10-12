<template>
  <div>

    <!-- for debugging -->
    <!-- <div v-for="item in ingredientLineItems">
      {{ item }}
    </div> -->
    <!-- for debugging -->

    <IngredientLineItem v-for="(item, index) in ingredientLineItems" :allowDelete="this.ingredientLineItems.length > 1"
      :ingredientData="item" :descriptors="this.descriptors" @ingredientRemove="removeIngredient(index)">
    </IngredientLineItem>

    <button @click="this.addIngredient">New ingredient</button>
  </div>
</template>

<script>
import IngredientLineItem from './IngredientLineItem.vue';

export default {
  name: "IngredientsInput",
  data() {
    return {
      ingredientLineItems: [],
      descriptors: [
        { text: "", value: undefined },
        { text: "chopped", value: "chopped" },
        { text: "sliced", value: "sliced" },
        { text: "minced", value: "minced" },
        { text: "peeled", value: "peeled" },
        { text: "other", value: "other" }
      ]
    };
  },
  mounted() {
    this.addIngredient();
  },
  methods: {
    addIngredient() {
      this.ingredientLineItems.push({});
    },
    removeIngredient(index) {
      this.ingredientLineItems.splice(index, 1)
    },
    getIngredients() {
      return this.ingredientLineItems;
    }
  },
  components: { IngredientLineItem }
};
</script>

<style></style>