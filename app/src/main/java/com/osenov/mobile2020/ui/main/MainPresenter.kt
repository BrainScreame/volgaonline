package com.osenov.mobile2020.ui.main

import com.osenov.mobile2020.di.scope.ConfigPersistent
import javax.inject.Inject

@ConfigPersistent
class MainPresenter
@Inject
constructor() : MainContract.Presenter() {

    private var operator: Operator? = null

    private var firstNumber : Double = 0.0
    private var result : Double = 0.0
    private var text : String = "0"

    override fun clickNumber(textNumber: String) {
        if(text == "0") {
            text =""
        }
        text += textNumber
        view.displayResult(text)
    }

    override fun clickOperator(operator: Operator) {
        if(operator == Operator.Sign) {
            if(text.isNotEmpty() && text[0] != '-') {
                text = "-$text"
            } else {
                text = text.replace("-", "")
            }
        } else {
            if(text != "" && this.operator == null) {
                firstNumber = text.toDouble()
            } else {
                clickEqual()
            }
            this.operator = operator
            text = ""
        }
    }

    override fun clear() {
        text = "0"
        firstNumber = 0.0
        result = 0.0
        operator = null
        view.displayResult(text)
    }

    override fun clickEqual() {
        if(operator != null && text != "") {
            when (operator) {
                Operator.Add -> {
                    result = firstNumber + text.toDouble()
                }
                Operator.Sub -> {
                    result = firstNumber - text.toDouble()
                }
                Operator.Multi -> {
                    result = firstNumber * text.toDouble()
                }
                Operator.Divide -> {
                    if (text == "0") {
                        view.displayCannotDivideByZeroError()
                        text = ""
                    } else {
                        result = firstNumber / text.toDouble()
                    }
                }
                Operator.Mod -> {
                    result = firstNumber % text.toDouble()
                }
                Operator.Sign -> {
                    result = firstNumber * -1
                }
            }
        }
        view.displayResult(getNumberToString(result))
        firstNumber = result
        operator = null
    }


    override fun attachView(view: MainContract.View) {
        super.attachView(view)
        view.displayResult(text)
    }

    private fun isWhole(value: Double):Boolean {
        return value - value.toInt() == 0.0
    }

    private fun getNumberToString(number : Double) : String {
        var numberStr = number.toString()
        if(isWhole(number)) {
            var tempNumberStr = ""
            for(char in numberStr) {
                if(char == '.') {
                    break
                } else {
                    tempNumberStr += char
                }
            }
            numberStr = tempNumberStr
        }
        return numberStr
    }

}
