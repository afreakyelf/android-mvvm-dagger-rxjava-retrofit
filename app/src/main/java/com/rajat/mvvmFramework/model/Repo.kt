package com.rajat.mvvmFramework.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Rajat Mittal on 23,March,2021
 */

class Repo(id: Long, name: String, description: String, owner: User, stars: Long, forks: Long) {
    val id: Long
    val name: String
    val description: String
    val owner: User

    @SerializedName("stargazers_count")
    val stars: Long

    @SerializedName("forks_count")
    val forks: Long

    init {
        this.id = id
        this.name = name
        this.description = description
        this.owner = owner
        this.stars = stars
        this.forks = forks
    }
}