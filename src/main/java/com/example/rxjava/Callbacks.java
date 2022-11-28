package com.example.rxjava;

import reactor.core.publisher.Flux;

public class Callbacks {
    public static void main(String[] args) {
        Flux.create((fluxSink -> {
            System.out.println("Inside Create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
            System.out.println("--completed");
        }))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext : "+ o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 1: "+s))
                .doOnRequest(l -> System.out.println("doOnRequest : "+l))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnError(err -> System.out.println("doOnError : "+err.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2: "+s))
                .doFirst(() -> System.out.println("doFirst 3"))
                .doFinally(signal -> System.out.println("doOnFinally :"+signal))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard :"+o))
                .subscribe(Util.subscriber());
    }
}
