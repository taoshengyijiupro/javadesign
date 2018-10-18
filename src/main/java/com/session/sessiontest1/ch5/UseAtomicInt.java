package com.session.sessiontest1.ch5;

import java.util.concurrent.atomic.AtomicInteger;

public class UseAtomicInt {
    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) {
        ai.getAndIncrement();
        System.out.println(ai.get());
    }
}
