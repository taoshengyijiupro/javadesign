package com.session.sessiontest1.ch5;

import java.util.concurrent.atomic.AtomicReference;

public class UseAtomicReference {
    public static AtomicReference<UserInfo> atomicUserRef = new
            AtomicReference<UserInfo>();//原子引用类型的实例
    public static void main(String[] args) {
        UserInfo user = new UserInfo("Mark", 15);//要修改的实体的实例
        atomicUserRef.set(user);
        UserInfo updateUser = new UserInfo("Bill", 17);//要变化成为的新实例
        atomicUserRef.compareAndSet(user,updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getAge());
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }


    static class UserInfo {
        private String name;
        private int age;
        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
    }
}


