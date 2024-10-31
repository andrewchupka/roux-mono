package com.roux.rouxapi.util

import com.roux.rouxapi.model.Recipe
import com.roux.rouxapi.model.requests.UpdateRecipe
import java.time.LocalDateTime

fun mapUpdateRequestToRecipe(requestData: UpdateRecipe, recipe: Recipe): Recipe {
    recipe.title = requestData.name ?: recipe.title
    recipe.description = requestData.description ?: recipe.description
    recipe.modifiedDate = LocalDateTime.now()
    return recipe
}