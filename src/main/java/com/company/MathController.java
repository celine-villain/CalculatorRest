package com.company;

import com.company.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    // SUM //
    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    // SUBSTRACTION //
    @GetMapping("/substraction/{numberOne}/{numberTwo}")
    public Double substraction(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        Double s = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return s;
    }

    // MULTIPLICATION //
    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // DIVISION //
    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        if (convertToDouble(numberTwo) == 0) throw new UnsupportedMathOperationException("Please set a value different from 0");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // AVERAGE //
    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return sum(numberOne, numberTwo) / 2;
    }

    // SQUARE //
    @GetMapping("/squareRoot/{numberOne}/{numberTwo}")
    public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception{
        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        if (convertToDouble(numberOne) < 0) throw new UnsupportedMathOperationException("Please set a positive value");
        return Math.sqrt(convertToDouble(numberOne));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        return isNumeric(strNumber) ? Double.parseDouble(strNumber.replaceAll(",", ".")) : 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        return strNumber.replaceAll(",", ".").matches("^[+-]?[0-9]*$");
    }

}
