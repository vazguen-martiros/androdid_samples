package com.dev.codemycloud.samplecalculadorpruebaunitaria

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val TAG = "CalculatorActivity"

    private var mCalculator: Calculator? = null

    private var mOperandOneEditText: EditText? = null
    private var mOperandTwoEditText: EditText? = null

    private var mResultTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCalculator =  Calculator();
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
    }


    fun onAdd(view: View?) {
        compute(Calculator.Operator.ADD)
    }


    fun onSub(view: View?) {
        compute(Calculator.Operator.SUB)
    }

    fun onDiv(view: View?) {
        try {
            compute(Calculator.Operator.DIV)
        } catch (iae: IllegalArgumentException) {
            Log.e(TAG, "IllegalArgumentException", iae)
            mResultTextView!!.setText(getString(R.string.computationError))
        }
    }

    /**
     * OnClick method called when the multiply Button is pressed.
     */
    fun onMul(view: View?) {
        compute(Calculator.Operator.MUL)
    }

    private fun compute(operator: Calculator.Operator) {
        val operandOne: Double
        val operandTwo: Double
        try {
            operandOne = mOperandOneEditText?.let { getOperand(it) }!!
            operandTwo = mOperandTwoEditText?.let { getOperand(it) }!!
        } catch (nfe: NumberFormatException) {
            Log.e(TAG, "NumberFormatException", nfe)
            mResultTextView!!.setText(getString(R.string.computationError))
            return
        }
        val result: String
        when (operator) {
            Calculator.Operator.ADD -> result = java.lang.String.valueOf(
                mCalculator!!.add(operandOne, operandTwo)
            )
            Calculator.Operator.SUB -> result = java.lang.String.valueOf(
                mCalculator!!.sub(operandOne, operandTwo)
            )
            Calculator.Operator.DIV -> result = java.lang.String.valueOf(
                mCalculator!!.div(operandOne, operandTwo)
            )
            Calculator.Operator.MUL -> result = java.lang.String.valueOf(
                mCalculator!!.mul(operandOne, operandTwo)
            )
            else -> result = getString(R.string.computationError)
        }
        mResultTextView!!.setText(result)
    }

    companion object {
        /**
         * @return the operand value entered in an EditText as double.
         */
        private fun getOperand(operandEditText: EditText): Double {
            val operandText = getOperandText(operandEditText)
            return java.lang.Double.valueOf(operandText)
        }

        /**
         * @return the operand text which was entered in an EditText.
         */
        private fun getOperandText(operandEditText: EditText): String {
            return operandEditText.getText().toString()
        }
    }
}