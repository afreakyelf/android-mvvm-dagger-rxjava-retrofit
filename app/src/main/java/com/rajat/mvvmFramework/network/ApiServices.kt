package com.rajat.mvvmFramework.network

import com.rajat.mvvmFramework.model.Repo
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Rajat Mittal on 23,March,2021
 */

interface ApiServices {
    @GET("users/afreakyelf/repos")
    fun getRepositories(): Single<List<Repo?>?>?
}