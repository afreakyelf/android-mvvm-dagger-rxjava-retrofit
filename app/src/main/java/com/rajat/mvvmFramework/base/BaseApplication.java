package com.rajat.mvvmFramework.base;

import com.rajat.mvvmFramework.dagger.component.ApplicationComponent;
import com.rajat.mvvmFramework.dagger.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by Rajat Mittal on 23,March,2021
 */

public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }
}