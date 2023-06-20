<template>
  <div>
    <p>Recipe: {{ recipe }}</p>
    <br/>
    <div class="formField">
      <label for="recipeTitle">Title: </label>
      <input id="recipeTitle" v-model="recipe['title']">
    </div>
    <div class="formField">
      <label for="recipeDesc">Description: </label>
      <input id="recipeDesc" v-model="recipe['description']">
    </div>
    <div class="formField">
      <label for="recipeTags">Tags: </label>
      <TagInput></TagInput>
    </div>

  </div>
</template>

<script>
import {makeRecipe} from '../models/recipe';
import TagInput from './TagInput.vue';

export default {
  components: { TagInput },
  data() {
    return {
      recipe: makeRecipe()
    }
  }
}
</script>
