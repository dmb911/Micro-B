package com.example.movie_search_app.model

data class Movie(
    var name: String? = null,
    var premiered: String? = null,
    var rating: Rating,
    var image: Image
)

data class Image (
    var medium: String? = null
)
data class Rating (
    var average: String? = null
)






