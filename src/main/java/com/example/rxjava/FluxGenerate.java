package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.getFaker().name().fullName());
        })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
