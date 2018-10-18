package com.session.sessiontest1.factory.abstracts;

public enum HumanEnum {
    //把世界上所有人类型都定义出来
    YelloMaleHuman("com.session.sessiontest1.factory.abstracts.YellowMaleHuman"),

    YelloFemaleHuman("com.session.sessiontest1.factory.abstracts.YellowFemaleHuman"),

    WhiteFemaleHuman("com.session.sessiontest1.factory.abstracts.WhiteFemaleHuman"),

    WhiteMaleHuman("com.session.sessiontest1.factory.abstracts.WhiteMaleHuman"),

    BlackFemaleHuman("com.session.sessiontest1.factory.abstracts.BlackFemaleHuman"),

    BlackMaleHuman("com.session.sessiontest1.factory.abstracts.BlackMaleHuman");

    private String value = "";

    //定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
