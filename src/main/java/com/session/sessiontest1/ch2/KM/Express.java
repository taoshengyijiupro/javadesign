package com.session.sessiontest1.ch2.KM;

public class Express {
    public final static String CITY = "ShangHai";
    private int km;/*快递运输里程数*/
    private String site;/*快递到达地点*/

    public Express() {
    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm() {
        this.km = 101;
        notify();
    }

    public synchronized void changeSite() {
        this.site = "BeiJing";
        notify();
    }

    public synchronized void waitKm() {
        while (this.km <= 100) {
            try {
                wait();
                System.out.println("Check Km thread[" + Thread.currentThread().getId()
                        + "] is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the Km is " + this.km + ",I will change db");
        }
    }

    public synchronized void waitSite() {
        while (this.site.equals(CITY)) {//快递到达目的地
            try {
                wait();
                System.out.println("Check Site thread[" + Thread.currentThread().getId()
                        + "] is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is " + this.site + ",I will call user");
    }
}
