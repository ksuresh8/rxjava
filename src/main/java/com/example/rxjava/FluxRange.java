package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxRange {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(1, 10);
        integerFlux.log().map(i -> Util.getFaker().name().fullName()).subscribe(Util.onNext());
    }
}
