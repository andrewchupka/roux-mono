package com.roux.rouxapi.model

data class RecipeTime (
    var prep: ItemTime,
    var cook: ItemTime,
    var total: ItemTime
)