package com.session.sessiontest1.lockredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

public class LockRedis {

    //redis线程池
    private JedisPool jedisPool;

    //同时在redis上创建相同的key
    private String REDIS_LOCK_KEY = "redis_lock";

    public LockRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 基于redis实现分布式锁的代码思路<br>
     * 核心方法：获取锁、释放锁
     *
     * @param acquireTimeOut:获取锁的超时时间：如果在规定的时间内没有获取到锁，直接放弃
     * @param timeOut:获取锁之后，设置key的过期时间，在规定时间内失效
     */
    public String getRedisLock(Long acquireTimeOut, Long timeOut) {
        Jedis conn = null;
        try {
            //1.建立redis连接
            conn = jedisPool.getResource();
            //2.定义redis对应key的value(随机数UUID)，释放锁用到，删除自己创建的key，不能删除别人创建的key
            String redisValue = UUID.randomUUID().toString();
            //3.获取锁之后，设置key的过期时间，在规定时间内失效
            int expireLock = (int) (timeOut / 1000);
            //4.二个时间：获取锁的超时时间：如果在规定的时间内没有获取到锁，直接放弃
            //5.使用循环机制 保证重复进行尝试获取锁，如果返回1，成功获取锁
            Long endTime = System.currentTimeMillis() + acquireTimeOut;
            while (System.currentTimeMillis() < endTime) {
                //获取锁
                //6.使用setnx命令插入对应的REDIS_LOCK_KEY，如果返回1，插入成功
                if (conn.setnx(REDIS_LOCK_KEY, redisValue) == 1) {
                    //设置对应key的有效期
                    conn.expire(REDIS_LOCK_KEY, expireLock);
                    return redisValue;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                conn.close();
            }
        }
        return null;
    }

    /**
     * 释放锁
     * @param redisValue
     */
    public void unRedisLock(String redisValue) {
        Jedis conn = null;
        try {
            conn = jedisPool.getResource();

            if (conn.get(REDIS_LOCK_KEY).equals(redisValue)){
                conn.del(REDIS_LOCK_KEY);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (conn!=null){
                conn.close();
            }
        }

        //key自动失效
        //整个程序执行完，删除key
    }
}
