/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.swexpr.statement;

import java.util.Calendar;

class DaysInMonth {
    private static int DAYS_IN_JAN = 31;
    private static int DAYS_IN_APR = 30;

    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        System.out.println("There are " +
                daysInMonth(today.get(Calendar.YEAR),
                        today.get(Calendar.MONTH)) +
                " days in this month.");
    }

    private static int daysInMonth(int year, int month) {
        switch (month) {
            case Calendar.JANUARY,
                    Calendar.MARCH,
                    Calendar.MAY,
                    Calendar.JULY,
                    Calendar.AUGUST,
                    Calendar.OCTOBER,
                    Calendar.DECEMBER -> {
                return DAYS_IN_JAN;
            }
            case Calendar.APRIL,
                    Calendar.JUNE,
                    Calendar.SEPTEMBER,
                    Calendar.NOVEMBER -> {
                return DAYS_IN_APR;
            }
            case Calendar.FEBRUARY -> {
                return daysInFec(year);
            }
            default -> throw new RuntimeException(
                    "Calendar in JDK does not work");
        }
    }

    private static int daysInFec(int year) {
        if (((year % 4 == 0) && !(year % 100 == 0))
                || (year % 400 == 0)) {
            return 29;
        }

        return 28;
    }
}
