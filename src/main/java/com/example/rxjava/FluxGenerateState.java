package com.example.rxjava;

import reactor.core.publisher.Flux;

public class FluxGenerateState {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = Util.getFaker().country().name();
                    sink.next(country);
                    System.out.println("Emitting country : "+country);
                    if(counter >= 10 || country.equals("Canada")){
                        sink.complete();
                    }
                    return counter+1;
                }
        )
                .take(3)
                .subscribe(Util.subscriber());
    }
}
