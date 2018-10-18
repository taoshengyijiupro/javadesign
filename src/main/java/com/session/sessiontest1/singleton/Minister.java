package com.session.sessiontest1.singleton;

public class Minister {

    public static void main(String[] args) {
        Emperor emperor1 = Emperor.getInstance();
        emperor1.emperorInfo(); //第一天见的皇帝叫什么名字呢？

        //第二天
        Emperor emperor2 = Emperor.getInstance();
        emperor2.emperorInfo();

        //第三天
        Emperor emperor3 = Emperor.getInstance();
        emperor3.emperorInfo();
    }
}
