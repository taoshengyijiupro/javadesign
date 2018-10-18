package com.session.sessiontest1.chain;

public abstract class Handler {
    //能处理的级别
    private int level = 0;

    //责任传递，下一个人责任人是谁
    private Handler nextHanlder;

    //每个类都要说明一下自己能处理哪些请求
    public Handler(int _level) {
        this.level = _level;
    }

    public void setNext(Handler _handler) {
        this.nextHanlder = _handler;
    }

    //一个女性（女儿，妻子或者是母亲）要求逛街，你要处理这个请求
    public final void HandleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHanlder != null) {
                this.nextHanlder.HandleMessage(women);
            } else {
                System.out.println("-----------没地方请示了，不做处理！---------\n");
            }
        }
    }

    //有请示那当然要回应
    public abstract void response(IWomen women);
}
