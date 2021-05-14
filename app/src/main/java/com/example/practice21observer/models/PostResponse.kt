package com.example.practice21observer.models


class PostResponse: ArrayList<PostResponseItem>()

data class PostResponseItem (
        val bode:String,
        val id:Int,
        val title:String,
        val userId:Int
)