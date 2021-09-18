/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.swexpr.legacy;

import java.util.Calendar;

class DaysInMonth {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        int month = today.get(Calendar.MONTH);
        int year = today.get(Calendar.YEAR);

    int daysInMonth = switch (month) {
        case Calendar.JANUARY:
        case Calendar.MARCH:
        case Calendar.MAY:
        case Calendar.JULY:
        case Calendar.AUGUST:
        case Calendar.OCTOBER:
        case Calendar.DECEMBER:
            yield 31;
        case Calendar.APRIL:
        case Calendar.JUNE:
        case Calendar.SEPTEMBER:
        case Calendar.NOVEMBER:
            yield 30;
        case Calendar.FEBRUARY:
            if (((year % 4 == 0) && !(year % 100 == 0))
                    || (year % 400 == 0)) {
                yield 29;
            } else {
                yield 28;
            }
        default:
            throw new RuntimeException(
                    "Calendar in JDK does not work");
        };

        System.out.println("There are " + daysInMonth + " days in this month.");
    }
}
