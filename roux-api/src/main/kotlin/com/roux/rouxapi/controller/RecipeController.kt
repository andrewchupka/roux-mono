package com.roux.rouxapi.controller

import com.roux.rouxapi.model.Recipe
import com.roux.rouxapi.model.requests.UpdateRecipe
import com.roux.rouxapi.repository.RecipeRepository
import com.roux.rouxapi.util.mapUpdateRequestToRecipe
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/recipes")
class RecipeController (
        @Autowired private val recipesRepository: RecipeRepository
){

    @GetMapping()
    fun getAllRecipes(): ResponseEntity<List<Recipe>> {
        val recipes = recipesRepository.findAll()
        return ResponseEntity.ok(recipes)
    }

    @PostMapping()
    fun createRecipe(@RequestBody request: Recipe): ResponseEntity<Recipe> {
        recipesRepository.save(request)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getRecipeById( @PathVariable("id") id: String) : ResponseEntity<Recipe> {
        val recipe = recipesRepository.findOneById(ObjectId(id))
        return ResponseEntity.ok(recipe)
    }

    @PutMapping("/{id}")
    fun updateRecipe(@PathVariable id: String, @RequestBody request: UpdateRecipe): ResponseEntity<Recipe> {
        var recipe = recipesRepository.findOneById(ObjectId(id))
        recipe = mapUpdateRequestToRecipe(request, recipe)
        recipesRepository.save(recipe)
        return ResponseEntity.ok(recipe)
    }

    @DeleteMapping("/{id}")
    fun deleteRecipe(@PathVariable id: String): ResponseEntity<Recipe> {
        var recipe = recipesRepository.findOneById(ObjectId(id))
        recipesRepository.delete(recipe)
        return ResponseEntity.ok(recipe)
    }

    @PutMapping("/{id}/tags")
    fun updateRecipeTags(@PathVariable id: String, @RequestBody request: List<String>): ResponseEntity<Recipe> {
        var recipe = recipesRepository.findOneById(ObjectId(id))
        recipe.tags = request
        recipesRepository.save(recipe)
        return ResponseEntity.ok(recipe)
    }


}