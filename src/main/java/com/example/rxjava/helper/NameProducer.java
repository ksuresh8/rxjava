package com.example.rxjava.helper;

import com.example.rxjava.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce(){
        String name = Util.getFaker().name().fullName();
        String tName = Thread.currentThread().getName();
        this.fluxSink.next(tName +" : "+name);
    }
}
