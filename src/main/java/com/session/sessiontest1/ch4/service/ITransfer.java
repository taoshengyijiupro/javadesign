package com.session.sessiontest1.ch4.service;

import com.session.sessiontest1.ch4.UserAccount;

public interface ITransfer {
    void transfer(UserAccount from, UserAccount to,int amount) throws InterruptedException;
}
