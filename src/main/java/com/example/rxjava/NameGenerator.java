package com.example.rxjava;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;


public class NameGenerator {

    public static List<String> getNames(int count){
        List<String> list = new ArrayList<>(count);
        for(int i = 0; i < count ; i++){
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> getDNames(int count){
        return Flux.range(1, count).map(i -> getName());
    }

    private static String getName(){
        Util.sleepSeconds(1);
        return Util.getFaker().name().fullName();
    }
}
