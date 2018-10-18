package com.session.sessiontest1.factory.abstracts;

public interface HumanFactory {
    //制造黄色人类
    public Human createYellowHuman();

    //制造一个白色人类
    public Human createWhiteHuman();

    //制造一个黑色人类
    public Human createBlackHuman();
}
