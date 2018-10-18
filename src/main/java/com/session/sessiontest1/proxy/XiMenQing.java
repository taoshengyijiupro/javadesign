package com.session.sessiontest1.proxy;

public class XiMenQing {
    public static void main(String[] args) {
        //WangPo wangPo = new WangPo();
        //wangPo.makeEyesWithMan(); //看到没，虽然表面上时王婆在做，实际上爽的是潘金莲
        //wangPo.happyWithMan();
        WangPo wangPo = new WangPo(new JiaShi());
        wangPo.happyWithMan();
        wangPo.makeEyesWithMan();
    }
}
