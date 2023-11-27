package com.roux.rouxapi.model

import org.bson.types.ObjectId

data class Equipment (
    val id : ObjectId = ObjectId.get(),
    var name: String,
    var quantity: Int
)