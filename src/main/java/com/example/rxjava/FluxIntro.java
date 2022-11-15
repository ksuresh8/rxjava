package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxIntro {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1,2,3,4);
        flux.subscribe(o -> System.out.println(o), o -> System.out.println(o.getMessage()), () -> System.out.println("Completed!"));
    }
}
