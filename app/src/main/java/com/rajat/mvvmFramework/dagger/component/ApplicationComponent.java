package com.rajat.mvvmFramework.dagger.component;


import android.app.Application;

import com.rajat.mvvmFramework.base.BaseApplication;
import com.rajat.mvvmFramework.dagger.module.ActivityBindingModule;
import com.rajat.mvvmFramework.dagger.module.NetworkModule;
import com.rajat.mvvmFramework.dagger.module.ContextModule;
import com.rajat.mvvmFramework.dagger.module.FragmentBindingModule;
import com.rajat.mvvmFramework.dagger.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by Rajat Mittal on 23,March,2021
 */

@Singleton
@Component(modules = {
        ContextModule.class,
        NetworkModule.class,
        AndroidSupportInjectionModule.class,
        FragmentBindingModule.class,
        ActivityBindingModule.class,
        ViewModelModule.class})

public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }

}