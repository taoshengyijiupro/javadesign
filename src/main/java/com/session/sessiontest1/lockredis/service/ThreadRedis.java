package com.session.sessiontest1.lockredis.service;

public class ThreadRedis extends Thread {

    private LockService lockService;

    public ThreadRedis(LockService lockService) {
        this.lockService = lockService;
    }

    @Override
    public void run() {
        lockService.secKill();
    }
}
