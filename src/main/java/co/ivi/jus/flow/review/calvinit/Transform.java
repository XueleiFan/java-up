/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.calvinit;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class Transform<T, R> extends SubmissionPublisher<R> implements Flow.Processor<T, R> {

    private final Function<T, R> oneThingFunc;

    private Flow.Subscription subscription;

    public Transform(Function<T, R> oneThingFunc) {
        super();
        this.oneThingFunc = oneThingFunc;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        submit(oneThingFunc.apply(item));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        subscription.cancel();
        closeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
        close();
    }
}
