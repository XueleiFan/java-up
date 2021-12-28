/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.xuling;

import co.ivi.jus.flow.reactive.Destination;

import java.time.DayOfWeek;

public class UseCase {
    public static void main(String[] args) throws InterruptedException {
        // blank
        Workdays.StartDay startDay = new Workdays.StartDay();
        Workdays.SpendDay spendDay = new Workdays.SpendDay();
        // Create subscriber for the processor
        Destination<DayOfWeek> subscriber = new Destination<>(
                values -> System.out.println("Got it: " + values.name()));
        Transform<Workdays, DayOfWeek> workdayTransform = new Transform<>((a, b) -> {
            DayOfWeek dayOfWeek = a.getDayOfWeek();
            return dayOfWeek.plus(b.getDays());
        });
        Workdays.getSpendDaysPublisher().subscribe(workdayTransform);
        workdayTransform.subscribe(subscriber);
        startDay.setDayOfWeek(DayOfWeek.FRIDAY);
        spendDay.setDays(2);
        Thread.sleep(20);
        startDay.setDayOfWeek(DayOfWeek.MONDAY);

        Workdays.getSpendDaysPublisher().close();
        Thread.sleep(2000);
    }
}
