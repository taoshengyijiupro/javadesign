package com.session.sessiontest1.templatemodel;

public abstract class HummerModel {
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();
    protected Boolean isAlarm(){
        return true;
    }

    final public void run(){
        this.start();
        this.engineBoom();
        if (this.isAlarm()){
            this.alarm();
        }
        this.stop();
    }
}
