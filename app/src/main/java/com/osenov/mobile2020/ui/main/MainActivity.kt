package com.osenov.mobile2020.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.osenov.mobile2020.*
import com.osenov.mobile2020.ui.base.BaseActivity
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    //Numbers
    @BindView(R.id.button0)
    lateinit var buttonZero: Button

    @BindView(R.id.button1)
    lateinit var buttonOne: Button

    @BindView(R.id.button2)
    lateinit var buttonTwo: Button

    @BindView(R.id.button3)
    lateinit var buttonThree: Button

    @BindView(R.id.button4)
    lateinit var buttonFour: Button

    @BindView(R.id.button5)
    lateinit var buttonFive: Button

    @BindView(R.id.button6)
    lateinit var buttonSix: Button

    @BindView(R.id.button7)
    lateinit var buttonSeven: Button

    @BindView(R.id.button8)
    lateinit var buttonEight: Button

    @BindView(R.id.button9)
    lateinit var buttonNine: Button


    @BindView(R.id.button_clear)
    lateinit var buttonClear: Button

    @BindView(R.id.button_sign)
    lateinit var buttonSign: Button

    @BindView(R.id.button_mod)
    lateinit var buttonMod: Button

    @BindView(R.id.button_dot)
    lateinit var buttonPoint: Button

    // Operations
    @BindView(R.id.button_divide)
    lateinit var buttonDivide: Button

    @BindView(R.id.button_multi)
    lateinit var buttonMulti: Button

    @BindView(R.id.button_sub)
    lateinit var buttonMinus: Button

    @BindView(R.id.button_add)
    lateinit var buttonPlus: Button

    @BindView(R.id.button_equal)
    lateinit var buttonEqually: Button

    @BindView(R.id.textViewInput)
    lateinit var textViewInput: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        ButterKnife.bind(this)
        presenter.attachView(this)
    }

    @OnClick(
        R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
        R.id.button6, R.id.button7, R.id.button8, R.id.button9
    ) fun onNumberClick(view: View) {
        when (view.id) {
            R.id.button0 -> {
                presenter.clickNumber(ZERO.toString())
            }
            R.id.button1 -> {
                presenter.clickNumber(ONE.toString())
            }
            R.id.button2 -> {
                presenter.clickNumber(TWO.toString())
            }
            R.id.button3 -> {
                presenter.clickNumber(THREE.toString())
            }
            R.id.button4 -> {
                presenter.clickNumber(FOUR.toString())
            }
            R.id.button5 -> {
                presenter.clickNumber(FIVE.toString())
            }
            R.id.button6 -> {
                presenter.clickNumber(SIX.toString())
            }
            R.id.button7 -> {
                presenter.clickNumber(SEVEN.toString())
            }
            R.id.button8 -> {
                presenter.clickNumber(EIGHT.toString())
            }
            R.id.button9 -> {
                presenter.clickNumber(NINE.toString())
            }
        }
    }

    @OnClick(
        R.id.button_divide, R.id.button_multi, R.id.button_sub, R.id.button_add,
        R.id.button_mod, R.id.button_sign
    ) fun onOperatorClick(view: View) {
        when (view.id) {
            R.id.button_divide -> {
                presenter.clickOperator(Operator.Divide)
            }
            R.id.button_multi -> {
                presenter.clickOperator(Operator.Multi)
            }
            R.id.button_sub -> {
                presenter.clickOperator(Operator.Sub)
            }
            R.id.button_add -> {
                presenter.clickOperator(Operator.Add)
            }
            R.id.button_mod -> {
                presenter.clickOperator(Operator.Mod)
            }
            R.id.button_sign -> {
                presenter.clickOperator(Operator.Sign)
            }
        }
    }

    @OnClick(R.id.button_clear, R.id.button_dot, R.id.button_equal)
    fun onClick(view: View) {
        when (view.id) {
            R.id.button_clear -> {
                presenter.clear()
            }
            R.id.button_dot -> {
                presenter.clickNumber(POINT.toString())
            }
            R.id.button_equal -> {
                presenter.clickEqual()
            }
        }
    }

    override fun displayResult(result: String) {
        textViewInput.text = result
    }

    override fun displayCannotDivideByZeroError() {
        textViewInput.text = "ERROR"
    }

    override fun displayError() {
        textViewInput.text = "ERROR"
    }

}