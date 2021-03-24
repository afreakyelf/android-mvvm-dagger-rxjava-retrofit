package com.rajat.mvvmFramework.network

import com.rajat.mvvmFramework.model.Repo
import io.reactivex.Observable
import io.reactivex.Single

import javax.inject.Inject

/**
 * Created by Rajat Mittal on 23,March,2021
 */

class ApiRepository @Inject constructor(private val repoService: ApiServices) {

    fun getRepositories(): Observable<List<Repo?>?>? {
        return repoService.getRepositories()
    }

}