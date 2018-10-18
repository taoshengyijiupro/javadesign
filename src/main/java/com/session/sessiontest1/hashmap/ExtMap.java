package com.session.sessiontest1.hashmap;

/**
 * 纯手写Map集合
 * @author linyonghong
 */
public interface ExtMap<K,V> {
    //向集合中插入元素
    V put(K k,V v);

    //根据K从集合中获取值
    V get(K k);

    //集合大小
    int size();

    interface Entry<K,V>{
        K getKey();

        V getValue();

        V setValue(V value);
    }
}
