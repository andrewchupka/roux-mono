package com.roux.rouxapi.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Recipe (
        @Id
        val id: ObjectId = ObjectId.get(),
        var title: String,
        var description: String,
        var createdDate: LocalDateTime = LocalDateTime.now(),
        var modifiedDate: LocalDateTime = LocalDateTime.now(),
        var tags: List<String>? = null,
        var time: RecipeTime,
        var ingredients: List<Ingredient>,
        var equipment: List<Equipment>,
        var directions: List<Direction>,
        var cookStats: CookStats = CookStats(0, null)
)