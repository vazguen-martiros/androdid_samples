package com.dev.codemycloud.samplecalculadorpruebaunitaria



class Calculator {
     enum class Operator {
        ADD, SUB, DIV, MUL
    }


    fun add(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand + secondOperand
    }


    fun sub(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand - secondOperand
    }


    fun div(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand / secondOperand
    }


    fun mul(firstOperand: Double, secondOperand: Double): Double {
        return firstOperand * secondOperand
    }
}