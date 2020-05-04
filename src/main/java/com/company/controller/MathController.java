package com.company.controller;

import com.company.Math.NumberFormat;
import com.company.Math.Operations;
import com.company.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!NumberFormat.isNumeric(numberOne) || !NumberFormat.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Operations.sum(NumberFormat.convertToDouble(numberOne), NumberFormat.convertToDouble(numberTwo));
    }

    @GetMapping("/substraction/{numberOne}/{numberTwo}")
    public Double substract(@PathVariable("numberOne") String numberOne,
                               @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!NumberFormat.isNumeric(numberOne) || !NumberFormat.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Operations.substract(NumberFormat.convertToDouble(numberOne), NumberFormat.convertToDouble(numberTwo));
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!NumberFormat.isNumeric(numberOne) || !NumberFormat.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return Operations.multiplication(NumberFormat.convertToDouble(numberOne), NumberFormat.convertToDouble(numberTwo));
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!NumberFormat.isNumeric(numberOne) || !NumberFormat.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        if (NumberFormat.convertToDouble(numberTwo) == 0) throw new UnsupportedMathOperationException("Please set a value different from 0");
        return Operations.division(NumberFormat.convertToDouble(numberOne), NumberFormat.convertToDouble(numberTwo));
    }

    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!NumberFormat.isNumeric(numberOne) || !NumberFormat.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return Operations.average(NumberFormat.convertToDouble(numberOne), NumberFormat.convertToDouble(numberTwo));
    }

    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception{
        if (!NumberFormat.isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value");
        if (NumberFormat.convertToDouble(number) < 0) throw new UnsupportedMathOperationException("Please set a positive value");
        return Operations.squareRoot(NumberFormat.convertToDouble(number));
    }

}
