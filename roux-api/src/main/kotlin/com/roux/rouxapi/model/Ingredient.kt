package com.roux.rouxapi.model

import org.bson.types.ObjectId

data class Ingredient (
    val id: ObjectId = ObjectId.get(),
    val name: String,
    val quantity: Float?,
    val descriptor: String?,
    val otherDescriptor: String?,
    val unit: String?
)