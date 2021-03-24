package com.rajat.mvvmFramework.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rajat.mvvmFramework.model.Repo
import com.rajat.mvvmFramework.network.ApiRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Rajat Mittal on 23,March,2021
 */


class ListViewModel @Inject constructor(private val repoRepository: ApiRepository) : ViewModel() {
    private var disposable: CompositeDisposable?
    private val repos = MutableLiveData<List<Repo>>()
    private val repoLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()
    fun getRepos(): LiveData<List<Repo>> {
        return repos
    }

    fun getError(): LiveData<Boolean> {
        return repoLoadError
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    private fun fetchRepos() {
        loading.value = true
        disposable!!.add(
            repoRepository.getRepositories()?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeWith(object : DisposableSingleObserver<List<Repo?>?>() {

                    override fun onError(e: Throwable) {
                        repoLoadError.value = true
                        loading.value = false
                    }

                    override fun onSuccess(value: List<Repo?>?) {
                        repoLoadError.value = false
                        repos.value = value as List<Repo>?
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (disposable != null) {
            disposable!!.clear()
            disposable = null
        }
    }

    init {
        disposable = CompositeDisposable()
        fetchRepos()
    }
}