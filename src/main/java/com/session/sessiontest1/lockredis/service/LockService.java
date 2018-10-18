package com.session.sessiontest1.lockredis.service;

import com.session.sessiontest1.lockredis.LockRedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class LockService {

    private static JedisPool pool = null;

    LockRedis lockRedis = new LockRedis(pool);

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(200);
        //设置最大空闲数
        config.setMaxIdle(8);
        //设置最大等待时间
        config.setMaxWaitMillis(1000*100);
        //在borrow一个jedis实例，是否需要验证，若为true，则所用jedis实例都是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config,"192.168.98.110",6379,3000);
    }

    public void secKill(){
        String redisValue = lockRedis.getRedisLock(5000L,5000L);
        if (redisValue==null){
            return;
        }
        lockRedis.unRedisLock(redisValue);
    }
}
