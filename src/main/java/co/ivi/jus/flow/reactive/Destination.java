/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.reactive;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class Destination<T> implements Flow.Subscriber<T>{
        private Flow.Subscription subscription;

    private final Consumer<T> consumer;

    public Destination(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        subscription.request(1);
        consumer.accept(item);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
