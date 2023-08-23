/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.swexpr.review.songor;

import java.time.Month;
import java.util.Calendar;

class DaysInMonth {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        Month month = Month.of(today.get(Calendar.MONTH) + 1);
        int year = today.get(Calendar.YEAR);

        int daysInMonth = switch (month) {
            case JANUARY,
                    MARCH,
                    MAY,
                    JULY,
                    AUGUST,
                    OCTOBER,
                    DECEMBER -> 31;
            case APRIL,
                    JUNE,
                    SEPTEMBER,
                    NOVEMBER -> 30;
            case FEBRUARY -> {
                if (((year % 4 == 0) && !(year % 100 == 0))
                        || (year % 400 == 0)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
        };

        System.out.println("There are " + daysInMonth + " days in this month.");
    }
}
