package com.example.rxjava;

import reactor.core.publisher.Flux;

public class Handle {
    public static void main(String[] args) {
        Flux.range(1,10)
                .handle(
                        (i, sink) -> {
                            if(i == 7) {
                                sink.complete();
                            } else {
                                sink.next(i);
                            }
                        }
                ).subscribe(Util.subscriber());
    }
}
