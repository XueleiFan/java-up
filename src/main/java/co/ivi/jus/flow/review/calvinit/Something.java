/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.calvinit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public sealed interface Something permits Something.OneThing, Something.AnotherThing {

    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd E", Locale.CHINA);

    LocalDate doIt(LocalDate startDate);

    /**
     * spendDays: 花费天数
     */
    record OneThing(int spendDays) implements Something {

        @Override
        public LocalDate doIt(LocalDate startDate) {
            LocalDate endDate = startDate.plusDays(spendDays);
            System.out.println("【" + DATE_TIME_FORMATTER.format(startDate) + "】开始做 OneThing，需要花费 " + spendDays
                    + " 天，做完后的日期是：" + DATE_TIME_FORMATTER.format(endDate));
            return endDate;
        }
    }

    /**
     * name: 事情名称，spendDays: 花费天数
     */
    record AnotherThing(String name, int spendDays) implements Something {

        @Override
        public LocalDate doIt(LocalDate startDate) {
            LocalDate endDate = startDate.plusDays(spendDays);
            System.out.println("【" + DATE_TIME_FORMATTER.format(startDate) + "】开始做 AnotherThing (" + name + ")，需要花费 "
                    + spendDays + " 天，做完后的日期是：" + DATE_TIME_FORMATTER.format(endDate));
            return endDate;
        }
    }
}
