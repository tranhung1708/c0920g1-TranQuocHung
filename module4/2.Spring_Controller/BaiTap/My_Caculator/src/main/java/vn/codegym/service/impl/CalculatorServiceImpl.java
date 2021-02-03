package vn.codegym.service.impl;

import org.springframework.stereotype.Service;
import vn.codegym.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int calculating(int num1, int num2, String operator) {
        int result = 0;
        if (num2 != 0) {
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
        } else {
            throw new ArithmeticException("Cannot division by zero");
        }
        return result;
    }
}
