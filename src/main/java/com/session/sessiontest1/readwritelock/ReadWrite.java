package com.session.sessiontest1.readwritelock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {
    //共享数据
    private Object data = null;

    //创建读写锁
    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    //获取数据:  多个线程可以同时读
    public void get() {
        //读锁
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 准备读数据");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " 读取数据为" + data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    //写数据
    public void put(Object data) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");
            /* 休眠 */
            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " 写入的数据: " + data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        /* 创建并启动3个读线程 */
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWrite.get();
                }
            }).start();

            /*创建3个写线程*/
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWrite.put(new Random().nextInt(8));
                }
            }).start();
        }
    }
}
