package com.example.rxjava;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber<T> implements Subscriber<T> {

    DefaultSubscriber(){

    }
    private String name = "";
    DefaultSubscriber(String name){
        this.name = name + " - ";
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + "Received : "+o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + "ERROR : "+throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name+"Completed");
    }
}
