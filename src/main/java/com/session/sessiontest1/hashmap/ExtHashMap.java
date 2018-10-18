package com.session.sessiontest1.hashmap;


public class ExtHashMap<K, V> implements ExtMap<K, V> {

    //1.定义table 存放HasMap 数组元素 默认是没有初始化容器
    Node<K, V>[] table = null;

    // 2. 实际用到table 存储容量 大小
    int size;

    // 3.HashMap默认负载因子，负载因子越小，hash冲突机率越低， 根据每个链表的个数
    float DEFAULT_LOAD_FACTOR = 0.75f;

    // 4.table默认初始大小 16
    static int DEFAULT_INITIAL_CAPACITY = 16;

    @Override
    public V put(K key, V value) {
        // 1.判断table 数组大小是否为空（如果为空的情况下 ，做初始化操作）
        if (table == null) {
            table = new Node[DEFAULT_INITIAL_CAPACITY];
        }
        // 2.判断数组是否需要扩容 实际存储容量=负载因子0.75*初始容量16 =12
        // 相当于如果长度大于12的时候就需要开始数组扩容
        if (size >= (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY)) {
            System.out.println("开始扩容啦！！！！");
            // resize();
        }
        //3.计算hash值指定下标位置
        int index = getIndex(key, DEFAULT_INITIAL_CAPACITY);
        Node<K, V> node = table[index];

        if (node == null) {
            node = new Node<K, V>(key, value, null);
            size++;
        } else {
            Node<K, V> newNode = node;
            while (newNode != null) {
                if (newNode.getKey().equals(key) || newNode.getKey() == key){
                    return newNode.setValue(value);
                }
            }
        }
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public int getIndex(K k, int length) {
        int index = (k == null) ? 0 : k.hashCode() % length;
        return index;
    }

    /**
     * 定义节点
     *
     * @param <K>
     * @param <V>
     */
    public class Node<K, V> implements Entry<K, V> {

        //存放map集合的key
        private K key;

        //存放map集合的
        private V value;

        //下一个节点
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            super();
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
