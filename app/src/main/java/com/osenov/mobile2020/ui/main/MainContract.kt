package com.osenov.mobile2020.ui.main

import com.osenov.mobile2020.ui.base.BasePresenter
import com.osenov.mobile2020.ui.base.MvpView

object MainContract {

    interface View : MvpView {
        fun displayResult(result: String)
        fun displayCannotDivideByZeroError()
        fun displayError()
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun clickNumber(textNumber : String)
        abstract fun clickOperator(operator: Operator)
        abstract fun clear()
        abstract fun clickEqual()
    }
}