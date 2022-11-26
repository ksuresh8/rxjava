package com.example.rxjava;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());
        monoFromFlux();
    }

    private static void doSomething(Flux<String> flux){

    }

    public static void monoFromFlux(){
        Flux.range(1, 10)
                .next()// next convert to Mono
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
