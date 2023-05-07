package com.simplecalculator.service.impl;

import com.simplecalculator.service.ICalculatorService;

public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public StringBuilder calculate(double firstOperand, double secondOperand, String operator) {
        StringBuilder message = new StringBuilder("Result: " + firstOperand + " " + operator + " " + secondOperand + " = ");
        double result = 0;
        switch (operator) {
            case "+" -> result = firstOperand + secondOperand;
            case "-" -> result = firstOperand - secondOperand;
            case "*" -> result = firstOperand * secondOperand;
            case "/" -> result = firstOperand / secondOperand;
        }
        message.append(result);
        return message;
    }
}
