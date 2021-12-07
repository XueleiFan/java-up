/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.calvinit;

import java.time.LocalDate;
import java.util.concurrent.SubmissionPublisher;

public class UseCase {

    public static void main(String[] args) throws InterruptedException {
        Something oneThing = new Something.OneThing(3);
        Something helloThing = new Something.AnotherThing("hello", 1);
        Something dummyThing = new Something.AnotherThing("dummy", 2);

        SubmissionPublisher<LocalDate> publisher = new SubmissionPublisher<>();
        Transform<LocalDate, LocalDate> oneThingTransform = new Transform<>(oneThing::doIt);
        Transform<LocalDate, LocalDate> helloThingTransform = new Transform<>(helloThing::doIt);
        Transform<LocalDate, LocalDate> dummyThingTransform = new Transform<>(dummyThing::doIt);
        Destination<LocalDate> subscriber = new Destination<>(date ->
                System.out.println("所以，最终完成这 3 件事情之后的日期是：" + Something.DATE_TIME_FORMATTER.format(date)));

        publisher.subscribe(oneThingTransform);
        oneThingTransform.subscribe(helloThingTransform);
        helloThingTransform.subscribe(dummyThingTransform);
        dummyThingTransform.subscribe(subscriber);

        // 今天开始做
        publisher.submit(LocalDate.now());
        publisher.close();

        Thread.sleep(1000L);
    }
}
