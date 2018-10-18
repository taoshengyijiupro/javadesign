package com.session.sessiontest1.chain;

public class Husband extends Handler {
    public Husband() {
        super(2);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是：同意\n");
    }
    /*@Override
    public void HandleMessage(IWomen women) {
        System.out.println("妻子的请示是："+women.getRequest());
        System.out.println("丈夫的答复是：同意");
    }*/
}
