package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxTake {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());
    }
}
