package com.session.sessiontest1.factory.abstracts;

public abstract class AbstractHumanFactory implements HumanFactory {
    Human human = null;

    protected Human createHuman(HumanEnum humanEnum) {
        try {
            if (!humanEnum.getValue().equals("")) {
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return human;
    }
}
