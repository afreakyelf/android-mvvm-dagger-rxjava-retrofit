package com.rajat.mvvmFramework.dagger.module

import com.rajat.mvvmFramework.ui.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Rajat Mittal on 23,March,2021
 */

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideListFragment(): ListFragment?

}