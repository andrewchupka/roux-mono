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

data class Tag(
        val id: ObjectId = ObjectId.get(),
        var name: String
) {
        fun equals(other: Tag?): Boolean {
                return name.equals(other?.name)
        }
}

data class ItemTime(
        var hours: Int,
        var minutes: Int
)

data class RecipeTime (
        var prep: ItemTime,
        var cook: ItemTime,
        var total: ItemTime
)

data class Ingredient (
        val id: ObjectId = ObjectId.get(),
        val name: String,
        val quantity: Float?,
        val descriptor: String?,
        val otherDescriptor: String?,
        val unit: String?
)

data class Equipment (
        val id : ObjectId = ObjectId.get(),
        var name: String,
        var quantity: Int
)

data class Direction(
        var order: Int,
        var text: String,

        // TODO: Need to figure out some kind of facility to link ingredients / supply items into the directions
) {
}

data class CookStats (
        var timesCooked: Int,
        var lastMade: LocalDateTime?
)
