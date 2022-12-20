<template>
    <div>
        <h1>Welcome to roux</h1>
        <RecipeEntry />
    </div>
</template>
  
<script>
import { defineComponent } from '@vue/composition-api'
import { makeRecipe } from '~/models/recipe'
export default defineComponent({
    data() {
        return {
            title: '',
            recipes: []
        }
    },
    async mounted() {
        await $mongo.insert(makeRecipe());
    }
})
</script>
  