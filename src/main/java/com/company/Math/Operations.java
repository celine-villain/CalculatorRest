package com.company.Math;

public class Operations {

    public static Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public static Double substract(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public static Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public static Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public static Double average(Double numberOne, Double numberTwo) {
        return sum(numberOne, numberTwo) / 2;
    }

    public static Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
