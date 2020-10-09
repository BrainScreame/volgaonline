package com.osenov.mobile2020.di.component

import android.content.Context
import com.osenov.mobile2020.Application
import com.osenov.mobile2020.di.module.ApplicationModule
import com.osenov.mobile2020.di.scope.ApplicationContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @ApplicationContext
    fun context(): Context
    fun application(): Application
}