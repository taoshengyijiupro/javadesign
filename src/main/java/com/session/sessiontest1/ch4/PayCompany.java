package com.session.sessiontest1.ch4;

import com.session.sessiontest1.ch4.service.ITransfer;
import com.session.sessiontest1.ch4.service.SafeOperate;
import com.session.sessiontest1.ch4.service.TrasnferAccount;

public class PayCompany {

    private static class TransferThread extends Thread{
        private String name;
        private UserAccount from;
        private UserAccount to;
        private int amount;
        private ITransfer transfer;

        public TransferThread(String name, UserAccount from, UserAccount to,
                              int amount, ITransfer transfer) {
            this.name = name;
            this.from = from;
            this.to = to;
            this.amount = amount;
            this.transfer = transfer;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(name);
            try {
                transfer.transfer(from,to,amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PayCompany payCompany = new PayCompany();
        UserAccount zhangsan = new UserAccount("zhangsan",20000);
        UserAccount lisi = new UserAccount("lisi",20000);
        //ITransfer transfer = new TrasnferAccount();
        ITransfer transfer = new SafeOperate();
        TransferThread zhangsanToLisi = new TransferThread("zhangsanToLisi"
                ,zhangsan,lisi,2000,transfer);
        TransferThread lisiToZhangsan = new TransferThread("lisiToZhangsan"
                ,lisi,zhangsan,4000,transfer);
        zhangsanToLisi.start();
        lisiToZhangsan.start();

    }
}
