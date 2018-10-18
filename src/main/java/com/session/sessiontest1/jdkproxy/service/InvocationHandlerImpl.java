package com.session.sessiontest1.jdkproxy.service;

import com.session.sessiontest1.jdkproxy.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;//业务实现类对象，调用具体调用业务方法

    public InvocationHandlerImpl(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("调用开始处理");
        result = method.invoke(target, args);
        System.out.println("调用开始结束");
        return result;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userService);
        //第一个参数是指定代理类的类加载器（我们传入当前测试类的类加载器)
        ClassLoader loader = userService.getClass().getClassLoader();
        //第二个参数是代理类需要实现的接口（我们传入被代理类实现的接口，这样生成的代理类和被代理类就实现了相同的接口）
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        //invocationHandler :第三个参数是invocation handler，用来处理方法的调用。这里传入我们自己实现的handler
        UserService newProxyInstance = (UserService) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        newProxyInstance.add();

    }

}
