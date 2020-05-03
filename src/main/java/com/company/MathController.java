package com.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping("/sum")
    @GetMapping(value = "/numberOne/numberTwo")
    public Double sum(@PathVariable("number one") String numberOne,
                      @PathVariable("number two") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    private Double convertToDouble(String numberOne) {
        return 1D;
    }

    private boolean isNumeric(String number) {
        return false;
    }

}
