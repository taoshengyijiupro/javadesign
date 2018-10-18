package com.session.sessiontest1.jdkproxy.service.impl;

import com.session.sessiontest1.jdkproxy.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("调用数据库新增");
    }
}
