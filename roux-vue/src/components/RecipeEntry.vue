<template>
  <div v-show="debug">
      <p>{{ recipe }}</p>
      <textarea v-on:change="updateRecipe($event)"></textarea>
    </div>
    
  <div class="recipeForm">
    <div>
      <label for="title">Title: </label>
      <input id="title" v-model="recipe['title']">
    </div>
    <div>
      <label for="desc">Description: </label>
      <textarea 
        rows="4"
        cols="50"
        id="desc" 
        v-model="recipe['description']"
      ></textarea>
    </div>
    <div>
      <label for="tags">Tags: </label>
      <TagInput id="tags" ref="tags" :tags="recipe.tags"></TagInput>
    </div>
    <div>
      <label for="ingredients">Ingredients: </label>
      <IngredientsInput id="ingredients" ref="ingredients" :ingredientLineItems="recipe.ingredients"></IngredientsInput>
    </div>
    <div>
      <label for="equipment">Equipment: </label>
      <EquipmentInput id="equipment" ref="equipment" :equipmentList="recipe.equipment"></EquipmentInput>
    </div>
    <div>
      <label for="time">Time: </label>
      <CookTimeInput id='time' ref="time" :time="recipe.time"></CookTimeInput>
    </div>
    <div>
      <label for="instructions">Directions: </label>
      <DirectionInput id="directions" ref="directions" :steps="recipe.directions"></DirectionInput>
    </div>
  </div>
  <button @click="submitRecipe">Submit</button>
</template>

<script>
import {makeRecipe} from '../models/recipe';
import { createRecipe } from '../services/roux-api-service';
import TagInput from './tags/TagInput.vue';
import IngredientsInput from './ingredients/IngredientsInput.vue';
import EquipmentInput from './equipment/EquipmentInput.vue';
import CookTimeInput from './time/CookTimeInput.vue';
import DirectionInput from './directions/DirectionsInput.vue'

export default {
  components: { TagInput, IngredientsInput, EquipmentInput, CookTimeInput, DirectionInput },
  data() {
    return {
      recipe: makeRecipe(),
      debug: import.meta.env.DEV
    }
  },
  methods: {
    updateRecipe(text) {
      let item = JSON.parse(text);
      console.log(item);
      this.recipe = item;
    },
    async submitRecipe() {
      // Normalize the recipe
      this.recipe.directions.splice(this.recipe.directions.length - 1, 1);
      this.recipe.ingredients = this.removeEmpties(this.recipe.ingredients)
      this.recipe.equipment = this.removeEmpties(this.recipe.equipment)

      try {
        await createRecipe(this.recipe);
      } catch (error) {
        alert("Error creating recipe");
        throw error;
      }

      this.recipe = makeRecipe();
    },
    removeEmpties(list) {
      return list.filter(item => Object.keys(item).length === 0)
    }
  }
}
</script>

<style>
.recipeForm {
  display: flex;
  flex-direction: column;
}

.recipeForm > div {
  display: flex;
  flex-direction: row;
  padding: 4px;
}

.recipeForm > div > label {
  padding-right: 15px;
}

</style>
