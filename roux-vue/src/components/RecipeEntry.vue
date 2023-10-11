<template>
  <div class="recipeForm">
    <p>Recipe: {{ recipe }}</p>
    <br/>
    <div>
      <label for="title">Title: </label>
      <input id="title" v-model="recipe['title']">
    </div>
    <div>
      <label for="desc">Description: </label>
      <input id="desc" v-model="recipe['description']">
    </div>
    <div>
      <label for="tags">Tags: </label>
      <TagInput id="tags" ref="tags"></TagInput>
    </div>
    <div>
      <label for="ingredients">Ingredients: </label>
      <IngredientsInput id="ingredients" ref="ingredients"></IngredientsInput>
    </div>
  </div>
  <button @click="submitRecipe">Submit</button>
</template>

<script>
import {makeRecipe} from '../models/recipe';
import TagInput from './tags/TagInput.vue';
import IngredientsInput from './ingredients/IngredientsInput.vue';

export default {
  components: { TagInput, IngredientsInput },
  data() {
    return {
      recipe: makeRecipe()
    }
  },
  methods: {
    submitRecipe() {
      this.recipe["tags"] = this.$refs.tags.getTags();
      this.recipe["ingredients"] = this.$refs.ingredients.getIngredients();
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
