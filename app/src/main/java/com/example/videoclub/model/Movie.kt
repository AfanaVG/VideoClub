package com.example.videoclub.model

import java.io.Serializable

data class Movie(
    val id :Int,
    var name :String,
    val description :String?,
    val cover :String?,
    val year: Int?

):Serializable