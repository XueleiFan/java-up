/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.xuling;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.BiFunction;

/**
 * @author jack
 * @since 2021/12/9
 **/
public class Transform <T, R> extends SubmissionPublisher<R>
        implements Flow.Processor<T, R> {

    private BiFunction<Workdays.StartDay, Workdays.SpendDay, R> transform;
    private Flow.Subscription subscription;
    private Workdays.StartDay startDay;
    private Workdays.SpendDay spendDay;

    public Transform(BiFunction<Workdays.StartDay, Workdays.SpendDay, R> transform) {
        super();
        this.transform = transform;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        switch (item) {
            case Workdays.StartDay startDay -> {
                if(this.spendDay != null) {
                    submit(transform.apply(startDay, spendDay));
                }
                this.startDay = startDay;
            }
            case Workdays.SpendDay spendDay -> {
                if(this.startDay != null) {
                    submit(transform.apply(startDay, spendDay));
                }
                this.spendDay = spendDay;
            }
            case default -> {
                //no code
            }
        }
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        closeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
        close();
    }
}
