package com.company.math;

public class NumberFormat {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        return isNumeric(strNumber) ? Double.parseDouble(strNumber.replaceAll(",", ".")) : 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        return strNumber.replaceAll(",", ".").matches("^[+-]?[0-9]*$");
    }
}
