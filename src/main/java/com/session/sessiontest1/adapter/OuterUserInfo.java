package com.session.sessiontest1.adapter;

import java.util.Map;

public class OuterUserInfo extends  OuterUser implements IUserInfo {

    private Map baseInfo = super.getUserBaseInfo();
    private Map homeInfo = super.getUserHomeInfo(); //员工的家庭 信息
    private Map officeInfo = super.getUserOfficeInfo(); //工作信息

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String)homeInfo.get("homeAddress");
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        return null;
    }

    @Override
    public String getJobPosition() {
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        return null;
    }
}
