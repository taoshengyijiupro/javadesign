package com.session.sessiontest1.ch4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserAccount {

    private String name;//账户名称
    private int money;//账户余额
    private final Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    public UserAccount() {
    }

    public UserAccount(String name,int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    //转入资金
    public void addMoney(int amount){
        money = money + amount;
    }

    //转出资金
    public void flyMoney(int amount){
        money = money - amount;
    }
}
