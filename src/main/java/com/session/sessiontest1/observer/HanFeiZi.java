package com.session.sessiontest1.observer;

public class HanFeiZi implements  IHanFeiZi{

    //韩非子是否在吃饭，作为监控的判断标准
    private boolean isHaveBreakfast = false;
    //韩非子是否在娱乐
    private boolean isHaveFun = false;

    //把李斯声明出来
    private ILiSi liSi =new LiSi();


    @Override
    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        this.liSi.update("韩非子在吃饭");
        //this.isHaveBreakfast =true;
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        this.liSi.update("韩非子在娱乐");
        //this.isHaveFun = true;
    }

    public boolean isHaveBreakfast() {
        return isHaveBreakfast;
    }

    public void setHaveBreakfast(boolean haveBreakfast) {
        isHaveBreakfast = haveBreakfast;
    }

    public boolean isHaveFun() {
        return isHaveFun;
    }

    public void setHaveFun(boolean haveFun) {
        isHaveFun = haveFun;
    }
}
