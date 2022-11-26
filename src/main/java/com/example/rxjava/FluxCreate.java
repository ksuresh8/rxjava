package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do{
                country = Util.getFaker().country().name();
                fluxSink.next(country);
            }while(!country.equals("Canada"));

//            fluxSink.next(1);
//            fluxSink.next(2);
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
