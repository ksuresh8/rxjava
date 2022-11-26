package com.example.rxjava;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    private static final Faker faker = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received: "+o);
    }

    public static Consumer<Throwable> onError(){
        return o -> System.out.println("ERROR : "+o.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed!");
    }

    public static Faker getFaker(){
        return faker;
    }

    public static void sleepSeconds(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Subscriber<Object> subscriber(){
        return new DefaultSubscriber<Object>();
    }

    public static Subscriber<Object> subscriber(String name){
        return new DefaultSubscriber<Object>(name);
    }
}
