package com.aamersohel.git.java;

public class IndianCurrency {
    
    private static final String[] ONES = new String[] {
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"    
    };
    
    private static final String[] TENS = new String[] {
        "",
        "",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety",
    };
    
    private static final String[] PLACES = new String[] {
        "",
        "",
        "Hundred",
        "Thousand",
        "",
        "Lakh",
        "",
        "Crore",
        ""
    };
    
    private static String getTens(int value) {
        if(value > 99 || value < 1) return "";
        if(value < 20) {
            return ONES[value];
        }
        return (TENS[value / 10] + " " + ONES[value % 10]).trim();
    }
    
    private static String getHundred(int value) {
        if(value < 100) return getTens(value);
        return (ONES[value / 100] + " " + PLACES[2] + " " + getTens(value % 100)).trim();
    }

    private static String getPositiveNumber(long value) {
        String result = getHundred((int)(value % 1000));
        value = value / 1000l;
        if(value < 1l) return result;
        int place = 3;
        while(value > 0) {
            result = (getTens((int)(value % 100)) + " " + PLACES[place] + " " + result).trim();
            value /= 100l;
            place += 2;
        }
        return result;
    }

    public static String toString(long value) throws CurrencyRangeException {
        if(Math.abs(value) > 999999999) throw new CurrencyRangeException();
        if(value == 0) return "Zero";
        return (value < 0)? "Minus " + getPositiveNumber(value * -1): getPositiveNumber(value);
    }

}