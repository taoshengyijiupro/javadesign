package com.session.sessiontest1.observer.moditify;

/**
 * 所有观察者，通用接口
 */
public interface Observer {

    //一发现别人有动静，自己也要行动起来
    public void update(String context);
}
