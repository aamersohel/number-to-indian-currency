package com.aamersohel.git.java;

public class IndianCurrency {
    
    public IndianCurrency() {
        System.out.println("IndianCurrency Constructor");
    }

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

    public static String toString(int value) {
        if(value < 0) {
            return "Minus " + getHundred(value);
        }
        if(value == 0) return "Zero";
        return getHundred(value);
    }

}