package com.session.sessiontest1.ch4.service;

import com.session.sessiontest1.ch4.UserAccount;

public class SafeOperate implements ITransfer {

    private static Object tieLock = new Object();

    @Override
    public void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException {
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);

        if (fromHash < toHash) {
            synchronized (from) {
                System.out.println(Thread.currentThread().getName() + " get " + from.getName());
                Thread.sleep(100);
                synchronized (to) {
                    System.out.println(Thread.currentThread().getName() + " get " + to.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                    System.out.println(from);
                    System.out.println(to);
                }
            }
        } else if (toHash < fromHash) {
            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + " get" + to.getName());
                Thread.sleep(100);
                synchronized (from) {
                    System.out.println(Thread.currentThread().getName() + " get" + from.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                    System.out.println(from);
                    System.out.println(to);
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (from) {
                    synchronized (to) {
                        from.flyMoney(amount);
                        to.addMoney(amount);
                    }
                }
            }
        }
    }
}
