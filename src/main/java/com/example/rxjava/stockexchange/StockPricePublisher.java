package com.example.rxjava.stockexchange;

import com.example.rxjava.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;


public class StockPricePublisher {
    public static Flux<Integer> getPrice(){
        AtomicInteger atomicReference = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicReference.getAndAccumulate(Util.getFaker().random().nextInt(-5,5), Integer::sum));
    }
}
