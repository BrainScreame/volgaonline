package com.osenov.mobile2020.ui.base

interface Presenter<in V : MvpView> {
    fun attachView(view: V)
    fun detachView()
}
