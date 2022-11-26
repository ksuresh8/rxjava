package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxCreateIssueFix {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do{
                country = Util.getFaker().country().name();
                fluxSink.next(country);
                System.out.println("emitted : "+country);
            }while(!country.equals("Canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
