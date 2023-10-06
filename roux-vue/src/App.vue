<template>
  <div>
    <h1>Welcome to roux</h1>
    <RecipeEntry />
  </div>
</template>

<script>
import RecipeEntry from "./components/RecipeEntry.vue";

export default {
  components: {
    RecipeEntry,
  },
  data() {
    return {
      title: "",
      recipes: [],
    };
  },
};
</script>
