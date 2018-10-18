package com.session.sessiontest1.templatemodel;

public class HummerH1Model extends HummerModel {
    private Boolean alarmFlag = true;//是否要响喇叭

    @Override
    public void start() {
        System.out.println("悍马H1发动...");
    }

    @Override
    public void stop() {
        System.out.println("悍马H1停车...");
    }

    @Override
    public void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    @Override
    public void engineBoom() {
        System.out.println("悍马H1引擎声音是这样在...");
    }

    @Override
    protected Boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarmFlag(Boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}
