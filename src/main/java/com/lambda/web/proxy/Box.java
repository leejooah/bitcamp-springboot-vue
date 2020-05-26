package com.lambda.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

@Component("box") @Lazy
public class Box<T> {
    private HashMap<String,T> box ;
    public  Box(){ box = new HashMap<>(); }
    // add, clear, get(i), get(list)
    public void put(String s, T t){box.put(s,t);}
    public void clear(){box.clear();}
    public T get(String k){
        Function<String, T> s = box::get;
        return s.apply(k);
    }
    public HashMap<String, T> get(){return box; }
    public int size(){ return box.size(); }
    public void newBox(){box = new HashMap<String, T>();}
}
