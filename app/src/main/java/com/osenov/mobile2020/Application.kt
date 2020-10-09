package com.osenov.mobile2020

import android.app.Application
import com.osenov.mobile2020.di.component.ApplicationComponent
import com.osenov.mobile2020.di.component.DaggerApplicationComponent
import com.osenov.mobile2020.di.module.ApplicationModule

class Application : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initDaggerComponent()
    }

    private fun initDaggerComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}