package com.example.rxjava;

import reactor.core.publisher.Flux;

public class HandleAssignment {
    public static void main(String[] args) {
        Flux.generate(
                sink -> {
                    sink.next(Util.getFaker().country().name());
                }
        ).handle( (country, syncSink) -> {
            syncSink.next(country);
            if(country.equals("Canada")){
                syncSink.complete();
            }
        } ).subscribe(Util.subscriber());
    }
}
