package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxGenerateAssigment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country = Util.getFaker().country().name();
            System.out.println("emitting country: "+country);
            synchronousSink.next(country);
            if(country.equals("Canada")){
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }
}
