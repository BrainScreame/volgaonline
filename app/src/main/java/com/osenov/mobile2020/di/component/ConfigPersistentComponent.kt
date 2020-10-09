package com.osenov.mobile2020.di.component

import com.osenov.mobile2020.di.module.ActivityModule
import com.osenov.mobile2020.di.scope.ConfigPersistent
import dagger.Component

@ConfigPersistent
@Component(dependencies = [ApplicationComponent::class])
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}
