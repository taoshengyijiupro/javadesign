package com.session.sessiontest1.lockredis;

import com.session.sessiontest1.lockredis.service.LockService;
import com.session.sessiontest1.lockredis.service.ThreadRedis;

public class test {

    public static void main(String[] args) {
        LockService lockService = new LockService();
        for (int i = 0; i < 50; i++) {
            ThreadRedis threadRedis = new ThreadRedis(lockService);
            threadRedis.start();
        }
    }
}
