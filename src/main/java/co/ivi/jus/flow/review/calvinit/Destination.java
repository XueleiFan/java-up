/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.calvinit;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class Destination<T> implements Flow.Subscriber<T> {

    private final Consumer<T> consumer;

    private Flow.Subscription subscription;

    public Destination(Consumer<T> consumer) {
        super();
        this.consumer = consumer;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        consumer.accept(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        subscription.cancel();
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
