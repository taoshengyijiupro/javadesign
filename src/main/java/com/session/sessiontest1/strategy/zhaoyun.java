package com.session.sessiontest1.strategy;

public class zhaoyun {
    public static void main(String[] args) {
        Context context;
        System.out.println("-----------刚刚到吴国的时候拆第一个-------------");
        context = new Context(new BackDoor());
        context.operate();
    }
}
