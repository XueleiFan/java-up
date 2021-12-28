/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.xuling;

import java.time.DayOfWeek;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author jack
 * @since 2021/12/9
 **/
public sealed class Workdays permits Workdays.StartDay, Workdays.SpendDay {

    public static SubmissionPublisher<Workdays> getSpendDaysPublisher() {
        return spendDaysPublisher;
    }

    private static final SubmissionPublisher<Workdays> spendDaysPublisher = new SubmissionPublisher<>();

    public static final class StartDay extends Workdays {
        public DayOfWeek getDayOfWeek() {
            return dayOfWeek;
        }

        public void setDayOfWeek(DayOfWeek dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            Workdays.getSpendDaysPublisher().submit(this);
        }

        private DayOfWeek dayOfWeek;
    }

    public static final class SpendDay extends Workdays {
        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
            Workdays.getSpendDaysPublisher().submit(this);
        }

        private int days;
    }
}
