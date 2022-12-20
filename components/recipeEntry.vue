<template>
    <div>
        <p>Recipe: {{ recipe }}</p>
        <div v-for="property in Object.keys(recipe)" :key=property>
            <div class="recipeField">
                <label for="{{property}}">{{ property.charAt(0).toUpperCase() + property.slice(1) }}: </label>
                <input id="{{property}}" v-model="recipe[`${property}`]">
            </div>
        </div>
    </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'
import {makeRecipe} from '~/models/recipe';

export default defineComponent({
    data() {
        return {
            recipe: makeRecipe()
        }
    }
})
</script>
