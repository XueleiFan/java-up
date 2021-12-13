/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.review.songor;

import co.ivi.jus.flow.reactive.Destination;
import co.ivi.jus.flow.reactive.Transform;

import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class UseCase {
    public static void main(String[] args) throws InterruptedException {
        transform(new Event(3, 4), UseCase::calculate);
        Thread.sleep(200);
    }

    public static void transform(Event event, Function<Event, Integer> function) {
        SubmissionPublisher<Event> publisher = new SubmissionPublisher<>();
        Transform<Event, Integer> transform = new Transform<>(function);
        Destination<Integer> subscriber = new Destination<>(System.out::println);
        publisher.subscribe(transform);
        transform.subscribe(subscriber);
        publisher.submit(event);
        publisher.close();
    }

    public static int calculate(Event event) {
        return (event.start() + event.duration() - 1) % 7;
    }

    public static record Event(int start, int duration) {
    }
}
