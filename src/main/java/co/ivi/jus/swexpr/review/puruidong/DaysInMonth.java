/*
 * Copyright (c) 2021, Ruidong pu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.swexpr.review.puruidong;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class DaysInMonth {

    public static int monthLength(Month month,boolean leapYear) {
        return switch (month) {
            case FEBRUARY -> (leapYear ? 29 : 28);
            case APRIL,
                    JUNE,
                    SEPTEMBER,
                    NOVEMBER -> 30;
            default -> 31;
        };
    }

    public static void main(String[] args) {

        var localDate = LocalDate.now();
        var isleapYear = localDate.isLeapYear();
        System.out.println(monthLength(localDate.getMonth(),isleapYear));
        System.out.println(localDate.getMonth().length(isleapYear));

        Calendar today = Calendar.getInstance();
        int month = today.get(Calendar.MONTH);
        int year = today.get(Calendar.YEAR);

        int daysInMonth = switch (month) {
            case Calendar.JANUARY,
                    Calendar.MARCH,
                    Calendar.MAY,
                    Calendar.JULY,
                    Calendar.AUGUST,
                    Calendar.OCTOBER,
                    Calendar.DECEMBER -> 31;
            case Calendar.APRIL,
                    Calendar.JUNE,
                    Calendar.SEPTEMBER,
                    Calendar.NOVEMBER -> 30;
            case Calendar.FEBRUARY -> {
                if (((year % 4 == 0) && !(year % 100 == 0))
                        || (year % 400 == 0)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default -> throw new RuntimeException(
                    "Calendar in JDK does not work");
        };

        System.out.println(
                "There are " + daysInMonth + " days in this month.");
    }


}
