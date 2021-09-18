/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.swexpr.breakout;

import java.util.Calendar;

class DaysInMonth {
    public static void main(String[] args) {
        System.out.println("There are " +
            daysInMonth(Integer.parseInt(args[0]), Integer.parseInt(args[1])) +
            " days");
    }

    private static int daysInMonth(int year, int month) {
        int daysInMonth = 0;
        switch (month) {
            case Calendar.JANUARY,
                    Calendar.MARCH,
                    Calendar.MAY,
                    Calendar.JULY,
                    Calendar.AUGUST,
                    Calendar.OCTOBER,
                    Calendar.DECEMBER ->
                daysInMonth = 31;
            case Calendar.APRIL,
                    Calendar.JUNE,
                    Calendar.SEPTEMBER,
                    Calendar.NOVEMBER ->
                daysInMonth = 30;
            case Calendar.FEBRUARY -> {
                if (((year % 4 == 0) && !(year % 100 == 0))
                        || (year % 400 == 0)) {
                    daysInMonth = 29;
                    break;
                }

                daysInMonth = 28;
            }
            // default -> throw new RuntimeException(
            //        "Calendar in JDK does not work");
        }

        return daysInMonth;
    }
}
