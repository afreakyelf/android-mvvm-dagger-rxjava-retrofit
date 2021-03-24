package com.rajat.mvvmFramework.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajat.mvvmFramework.base.ViewModelFactory
import com.rajat.mvvmFramework.dagger.util.ViewModelKey
import com.rajat.mvvmFramework.ui.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Rajat Mittal on 23,March,2021
 */

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel?): ViewModel?

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?

}