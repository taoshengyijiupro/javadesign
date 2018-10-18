package com.session.sessiontest1.singleton;

public class SingletonPattern {

    private static final SingletonPattern  singletonPattern = new SingletonPattern();

    private SingletonPattern(){

    }
    public synchronized static SingletonPattern getInstance(){
        return singletonPattern;
    }
}
