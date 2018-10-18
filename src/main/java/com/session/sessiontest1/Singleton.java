package com.session.sessiontest1;

/**
 * 饿汉式
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    private static Singleton getInstance(){
        return instance;
    }

}
