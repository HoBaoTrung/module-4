package com.codegym.calculator.service;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Double calculate(String operator, double num1, double num2) {
        try {
            switch (operator) {
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                case "*":
                    return num1 * num2;
                case "/":
                    if (num2 == 0) {
                        throw new IllegalArgumentException("Không thể chia cho 0!");
                    }
                    return num1 / num2;
                default:
                    throw new IllegalArgumentException("Phép toán không hợp lệ!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Lỗi khi thực hiện phép toán: " + e.getMessage());
        }
    }
}
