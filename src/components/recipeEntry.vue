<template>
  <div>
    <p>Recipe: {{ recipe }}</p>
    <br/>
    <div>
      <label for="recipeTitle">Title: </label>
      <input id="recipeTitle" v-model="recipe['title']">
    </div>
    <div>
      <label for="recipeDesc">Description: </label>
      <input id="recipeDesc" v-model="recipe['description']">
    </div>
    <div>
      <label for="recipeTags">Tags: </label>
      <TagInput ref="tags"></TagInput>
    </div>
  </div>
  <button @click="submitRecipe">Submit</button>
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
  },
  methods: {
    submitRecipe() {
      this.recipe["tags"] = this.$refs.tags.getTags();
    }
  }
}
</script>
