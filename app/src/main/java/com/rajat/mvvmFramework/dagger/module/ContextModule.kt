package com.rajat.mvvmFramework.dagger.module;

import android.app.Application
import android.content.Context

import dagger.Binds
import dagger.Module

/**
 * Created by Rajat Mittal on 23,March,2021
 */

@Module
abstract class ContextModule {
    @Binds
    abstract fun provideContext(application: Application?): Context?
}