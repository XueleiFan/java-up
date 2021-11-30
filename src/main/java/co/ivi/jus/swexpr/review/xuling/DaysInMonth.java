/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.swexpr.review.xuling;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.util.Calendar;

/**
 * homework for 05
 *
 * @author jack
 * @since 2021/11/30
 **/
public class DaysInMonth {

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static void main(String[] args) {

        // use the same date lib
        LocalDate localDate = LocalDate.now();
        Month month = localDate.getMonth();

        /**
        Calendar today = Calendar.getInstance();
        // this still will throw exception
        Month month = Month.of(today.get(Calendar.MONTH) + 1);
        boolean isLeapYear = isLeapYear(today.get(Calendar.YEAR));
         **/

        // Hints: could we replace the integer month
        // with an exhaustive enumeration?
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
                if(isLeapYear(localDate.getYear())) {
                    yield 29;
                }
                yield 28;
            }
        };

        System.out.println("There are " + daysInMonth + " days in this month.");
    }
}
