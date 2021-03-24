package com.rajat.mvvmFramework.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Rajat Mittal on 23,March,2021
 */

abstract class BaseActivity : DaggerAppCompatActivity() {

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        ButterKnife.bind(this)
    }
}