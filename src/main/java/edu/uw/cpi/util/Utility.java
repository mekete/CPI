package edu.uw.cpi.util;

import java.time.Month;
import java.util.Locale;

public class Utility {

    public static boolean isMonth(String month) {
        try {
            Month.valueOf(month.toUpperCase(Locale.ENGLISH));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isFourDigitInteger(String str) {
        if (str == null) {
            return false;
        }

        // Check if the string has a length of 4
        if (str.length() != 4) {
            return false;
        }

        // Check if the string is a valid integer
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
