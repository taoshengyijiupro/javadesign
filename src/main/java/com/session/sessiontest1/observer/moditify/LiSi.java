package com.session.sessiontest1.observer.moditify;

import java.util.Observable;
import java.util.Observer;

public class LiSi implements Observer {

    //汇报给秦始皇
    private void reportToQiShiHuang(String reportContext) {
        System.out.println("李斯：报告，秦老板！韩非子有活动了--->" + reportContext);
    }

    @Override
    public void update(Observable observable, Object obj) {
        System.out.println("李斯：观察到韩非子活动，开始向老板汇报了...");
        this.reportToQiShiHuang(obj.toString());
        System.out.println("李斯：汇报完毕，秦老板赏给他两个萝卜吃吃...\n");
    }
}
