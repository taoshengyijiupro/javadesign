package com.session.sessiontest1.ch4;

public class NormalDeadLock {

    private static Object valueFirst = new Object();//第一个锁
    private static Object valueSecond = new Object();//第二个锁

    //先拿第一把锁   再拿第二把锁
    private static void firstToSecond() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (valueFirst){
            System.out.println(threadName + " get valueFirst");
            Thread.sleep(100);
            synchronized (valueSecond){
                System.out.println(threadName + " get valueSecond");
            }
        }
    }

    //先拿第一把锁   再拿第二把锁
    private static void secondToFirst() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (valueFirst){
            System.out.println(threadName + "get first-second");
            Thread.sleep(100);
            synchronized (valueSecond){
                System.out.println(threadName + "get first-second");
            }
        }

    }

    //定义一个子线程，先拿第二把锁
    public static class TestThread extends Thread{
        private String name;
        public TestThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            try {
                secondToFirst();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Thread.currentThread().setName("TestDeadLock");
        TestThread testThread = new TestThread("SubTestDeadLock");
        //子线程先执行
        testThread.start();
        try {
            //主线程在执行
            firstToSecond();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
