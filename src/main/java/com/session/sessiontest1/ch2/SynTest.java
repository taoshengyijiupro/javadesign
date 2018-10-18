package com.session.sessiontest1.ch2;

public class SynTest {
    private int age = 100000;

    private static class TestThread extends Thread{
        private SynTest synTest;

        public TestThread(String name, SynTest synTest) {
            super(name);
            this.synTest = synTest;
        }

        @Override
        public void run() {
           for (int i=0;i<100000;i++){
               synTest.test();
           }
           System.out.println(Thread.currentThread().getName() + "age = " + synTest.getAge());
        }
    }

    public void test(){
        age++;
    }

    public void test2(){
        age--;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws InterruptedException {
        SynTest synTest = new SynTest();
        Thread endThread = new TestThread("endThread",synTest);
        endThread.start();

        for(int i=0;i<100000;i++) {//递减100000
            synTest.test2();
        }

        System.out.println(Thread.currentThread().getName()
                +" age =  "+synTest.getAge());
    }
}
