package com.session.sessiontest1.ch2;

public class VolatileUnsafe {

    public static class VolatileVar implements Runnable{
        private static Object o = new Object();
        private volatile int a = 0;
        @Override
        public void run() {
            try {
                synchronized (o){
                    a = a + 1;
                    System.out.println(Thread.currentThread().getName() + ":----" + a);
                    Thread.sleep(100);
                    a = a + 1;
                    System.out.println(Thread.currentThread().getName() + ":----" + a);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        VolatileVar v=new VolatileVar();
        Thread t1 = new Thread(v);
        Thread t2 = new Thread(v);
        Thread t3 = new Thread(v);
        Thread t4 = new Thread(v);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
