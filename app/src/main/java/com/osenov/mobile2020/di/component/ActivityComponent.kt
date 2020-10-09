package com.osenov.mobile2020.di.component

import com.osenov.mobile2020.di.module.ActivityModule
import com.osenov.mobile2020.di.scope.PerActivity
import com.osenov.mobile2020.ui.main.MainActivity

import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}