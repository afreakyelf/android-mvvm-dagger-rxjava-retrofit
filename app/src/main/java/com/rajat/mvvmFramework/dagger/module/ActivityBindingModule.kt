package com.rajat.mvvmFramework.dagger.module

import com.rajat.mvvmFramework.MainActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector

/**
 * Created by Rajat Mittal on 23,March,2021
 */

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity?
}